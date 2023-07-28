class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        
        output = ""
        i = 0
        for space in spaces:
            output += s[i:space]
            output += " "
            i = space
        output += s[i:]
        return output