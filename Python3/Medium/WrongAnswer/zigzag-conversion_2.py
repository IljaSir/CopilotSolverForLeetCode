class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        result = ''
        for i in range(numRows):
            if i == 0 or i == numRows - 1:
                result += s[i::2 * numRows - 2]
            else:
                result += s[i::2 * numRows - 2] + s[2 * numRows - 2 - i::2 * numRows - 2]
        return result