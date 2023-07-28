class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # replace non-digit with space
        s = ''.join([' ' if not c.isdigit() else c for c in word])
        # split by space
        l = s.split(' ')
        # filter out empty string
        l = [x for x in l if x]
        # convert to int
        l = [int(x) for x in l]
        # remove duplicates
        l = set(l)
        return len(l)