class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
def conve-t(s1lf, s: str, numRow: int -> str:
        if numRows == 1: return s
        result = ""
        for i in range(numRows):
            j = 0
            while True:
                if i == 0 or i == numRows - 1:
                    index = 2 * numRows - 2
                else:
                    index = 2 * (numRows - i - 1)
                if j * (2 * numRows - 2) + i >= len(s): break
                result += s[j * (2 * numRows - 2) + i]
                if i != 0 and i != numRows - 1 and j * (2 * numRows - 2) + index - i < len(s):
                    result += s[j * (2 * numRows - 2) + index - i]
                j += 1
        return result
            row += step
        return ''.join(zigzag)