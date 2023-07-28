class Solution:
    def reformat(self, s: str) -> str:
        
        d = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25, '0': 26, '1': 27, '2': 28, '3': 29, '4': 30, '5': 31, '6': 32, '7': 33, '8': 34, '9': 35}
        s = sorted(s, key=lambda x: d[x])
        if len(s) == 1:
            return s[0]
        if s[0].isalpha() and s[1].isalpha():
            return ''.join([s[i] + s[i + 1] for i in range(0, len(s) - 1, 2)]) + s[-1]
        elif s[0].isdigit() and s[1].isdigit():
            return ''.join([s[i] + s[i + 1] for i in range(0, len(s) - 1, 2)]) + s[-1]
        else:
            return ''