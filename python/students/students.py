"""
program to get students info from a file and display the appropriate
information for a given criteria
created by Dobromir Marinov - 04/12/16
"""


def stringToTuple(info):
    """ 
    Creates a student tuple with 5 items from a given string
    arguments: info: string: string with the student info
    returns: student: tuple: 5 item tuple
    """

    # split the list into single words
    info = info.split()

    # Add all of the other names into one item
    for i in range(4, len(info) - 1):
        info[3] = info[3] + " " + info[4]
        info.pop(4)

    # switch the positions of surname and other names
    info[3], info[-1] = info[-1], info[3]

    # convert into tuple and return
    student = tuple(info)
    return student


def studentOutput(student):
    """
    Prints the details of a student on a single output line
    arguments: student: tuple: 5 item tuple with student info
    """

    # create the name string and print it in a 34 character field (32 for the name and two for the ', ')
    print(format(student[3] + ", " + student[4], "34s"), end=' ')

    # print everything else with the appropriate caharcter fields
    print(format(student[0], "8s"), end=' ')
    print(format(student[2], "7s"), end=' ')
    print(format("Year " + student[1], "6s"))


# Ask the user to provide a file
inFile = input("Specify input file: ")

# Try to open the file provided
try:
    fIn = open(inFile)
except IOError as e:
    fIn = None
    print("Failed to open", inFile, "- program aborted")

# If the file is successfully opened
if fIn != None:

    # convert each line into a tuple and add it to a list
    studentList = []
    for line in fIn:
        studentList.append(stringToTuple(line))

    # output each item of the list
    for item in studentList:
        studentOutput(item)

    # Display the options
    print("\nFind student by:")
    print("1 - Degree scheme")
    print("2 - Year in range")
    print("3 - Registration number")
    print("0 - Quit")

    # Start the loop
    choice = '100'
    while choice != '0':

        # Ask user for selection
        choice = input("\nEnter your choice(0-3):")

        # Display message if the choice is incorrect
        if choice not in "0123":
            print("Invalid input, please try again!")

        # Search by degree scheme
        if choice == "1":
            # Ask user for the degree scheme
            degreeScheme = input("\nEnter a degree scheme:")
            isEmpty = True
            tempList = []

            # Loop through the list and search for matches
            for item in studentList:
                if item[2] == degreeScheme:
                    tempList.append(item)
                    isEmpty = False

            # Sort the new list and display it
            tempList = sorted(tempList, key=lambda student: student[3] + student[4])
            for item in tempList:
                studentOutput(item)

            # If no match is found display appropriate message
            if isEmpty:
                print("There is no student with the given degree scheme!")

        # Search by year in range
        if choice == "2":

            # Ask the user to input the range and check if it is correct
            isEmpty = True
            areValid = True
            try:
                minYear = int(input("\nEnter the lower bound for the year range:"))
                maxYear = int(input("Enter the upper bound for the year range:"))
            except:
                areValid = False
                print("The input should be an integer!")

            # If the user supplied two integers check if they give a valid range
            if areValid:
                if minYear > maxYear:
                    print("Invalid range!")
                else:
                    for item in studentList:
                        # Loop through and display the items where the year is in the range (inclusive)
                        for i in range(minYear, maxYear + 1):
                            if item[1] == str(i):
                                studentOutput(item)
                                isEmpty = False
                # If no match is found display the appropriate message
                if isEmpty:
                    print("There is no student in the given year range!")

        # Search by registration number
        if choice == "3":

            # Ask user for the reg number
            regNumber = input("\nEnter a registration number:")
            isEmpty = True

            # Loop through the list and search for matches
            for item in studentList:
                if item[0] == regNumber:
                    # Display in the specific format
                    print(item[4] + " " + item[3])
                    isEmpty = False

            # If no match is found display appropriate message
            if isEmpty:
                print("There is no student with the given registration number!")
