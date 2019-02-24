"""
Game of Hangman
created by Dobromir Marinov - 04/12/16
"""

import random


def initialSetup(secretWord, lives):
    """ 
    Create the dict object from the given secret word and set the total amount of lives
    arguments:
    secretWord: string: the secret word used for the game
    lives: int: total number of lives
    returns: gameState: dict: A dictionary representing the state of the game
    """

    # Create an empty dict
    gameState = {}

    # Setup the state of the game
    gameState["secretWord"] = secretWord
    gameState["currentState"] = len(secretWord) * "*"
    gameState["lives"] = lives

    # Return the created dict
    return gameState


def hasWon(gameState):
    """ 
    Check if the word has been successfully guessed
    arguments:
    gameState: dict: the state of the game
    returns: True if all letters are guessed False otherwise 
    """

    # Check if the player has guessed the whole word
    if gameState["secretWord"] == gameState["currentState"]:
        return True
    else:
        return False


def livesLeft(gameState):
    """
    Returns the ammount of lives left
    arguments: gameState: dict: the state of the game
    return: lives: int: The number of lives left
    """

    # Extract the lives from the dict
    lives = gameState["lives"]
    return lives


def displayLine(gameState):
    """
    Returns information for the game state to the player
    Arguments: gameState: dict: the state of the game
    return: line: str: string with the game state information formated appropriately
    """

    # Assemble the game state line
    lives = str(gameState["lives"])
    line = "\nWORD: " + gameState["currentState"] + "; you have " + lives + " lives left"
    return line


def makeGuess(gameState, guess):
    """
    Checks if the guessed letter appears in the secret word or not
    and executes appropriate actions
    Arguments:
    gameState: dict: the state of the game
    guess: char: the guessed letter
    return: num: int: the nunmber of times the letter occurs in the secret word
    """

    num = 0
    # Make the current state into a list so it can be eddited
    currentState = list(gameState["currentState"])

    # Loop through the secret word and see if the guessed letter appear anywhere
    for i in range(0, len(gameState["secretWord"])):
        if gameState["secretWord"][i] == guess:
            currentState[i] = guess
            num = num + 1

    # Decrement the lives if the guess is incorrect and display appropriate message
    if num == 0:
        gameState["lives"] = gameState["lives"] - 1
        return "The letter " + guess + " does not occur in the word"
    # Reveal the letters if the guess is correct and display appropriate message
    elif num == 1:
        gameState["currentState"] = "".join(currentState)
        return "The letter " + guess + " occurs " + str(num) + " time in the word"
    else:
        gameState["currentState"] = "".join(currentState)
        return "The letter " + guess + " occurs " + str(num) + " times in the word"


def playGame(secretWord, lives):
    """
    Main function of the game, connects all other functions into one functional game
    Arguments:
    secretWord: str: string with the secret word to be guessed
    lives: int: the total number of lives
    """

    # Set the game state
    gameState = initialSetup(secretWord, lives)
    print(displayLine(gameState))

    # Try to guess the word while you have lives left and the word is not guessed
    while livesLeft(gameState) > 0 and not hasWon(gameState):

        # Display information to the user
        displayLine(gameState)
        # Get the guess of the player
        guess = input("\nGuess a letter:")

        # Check if the player has entered a single upper-case letter
        if len(guess) > 1:
            print("Please enter only one upper-case letter")
        elif guess.isalpha() and guess.isupper():

            # Print the result
            print(makeGuess(gameState, guess))

            # Print the game state if the player has any lives left and has not won
            if livesLeft(gameState) != 0 and not hasWon(gameState):
                print(displayLine(gameState))
        else:
            print("That is not an upper-case letter - try again")

    # Game over you lost message
    if livesLeft(gameState) == 0:
        print("\nYou have no lives left - you have been hung!")
        print("The word was " + secretWord)
    # Game over you won message
    else:
        print("\nWord: " + secretWord)
        print("Well done - you have guessed the word correctly")


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

    # create an empty list and fill it with the words from the file
    words = []
    for line in fIn:
        words.append(line.strip())

    # Start the game loop
    isPlaying = True

    while isPlaying:

        # Show the difficulty selection
        print("\nSelect a difficulty:")
        print("1 - Easy")
        print("2 - Intermediate")
        print("3 - Hard")

        # Let the player choose the difficulty
        difficulty = 0
        while difficulty <= 0 or difficulty > 3:
            try:
                difficulty = int(input("Please enter your choice(1-3): "))
                if difficulty <= 0 or difficulty > 3:
                    print("The input should be in the range 1-3!\n")
            except:
                print("The input should be an integer!\n")

        # Select a random word from the word list
        secretWord = random.choice(words)

        # Returns 5 for hard, 10 for intermediate, 15 for easy
        lives = (4 - difficulty) * 5

        # call the main game function
        playGame(secretWord, lives)

        # Ask the player to play again
        print("\nDo you want to play again?")
        playAgain = "ofcourseyoudo"
        while playAgain not in "YN" or len(playAgain) != 1:
            playAgain = input("Make your choice Y/N: ")
            if playAgain not in "YN" or len(playAgain) != 1:
                print("Invalid choice, please try again!\n")
        if playAgain == "N":
            isPlaying = False
