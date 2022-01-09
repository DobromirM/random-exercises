symbols = (')', '!', '@', '#', '$', '%', '^', '&', '*', '(')

if __name__ == '__main__':
    song = '012012012612612612'
    strings = ['e | --', 'B | --', 'G | --', 'D | --', 'A | --', 'E | --']

    for n in song:

        if n.islower():
            value = ord(n) - 97
            modifier = False
        elif n.isupper():
            value = ord(n) - 65
            modifier = True
        elif n.isdigit():
            value = int(n) + 26
            modifier = False
        else:
            value = symbols.index(n) + 26
            modifier = True

        string = value // 6
        value = value % 6 + 1

        for (i, s) in enumerate(strings):
            if modifier:
                if i == string:
                    strings[i] += f'({value})--'
                else:
                    strings[i] += f'-----'
            else:
                if i == string:
                    strings[i] += f'{value}--'
                else:
                    strings[i] += f'---'

    for string in strings:
        string += '|'
        print(string)
