class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # replace non-digits with spaces
        word = re.sub(r'\D', ' ', word)
        # remove leading spaces
        word = word.lstrip()
        # split on spaces
        word = word.split(' ')
        # remove leading zeros
        word = [int(x) for x in word]
        # remove duplicates
        word = set(word)
        return len(word)