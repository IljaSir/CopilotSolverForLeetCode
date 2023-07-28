class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        
        i = 0
        res = ""
        for space in spaces:
            res += s[i:space] + " "
            i = space
        res += s[i:]
        return res