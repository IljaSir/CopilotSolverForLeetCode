class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        n = len(s)
        res = ""
        for i in range(numRows):
            j = i
            while j < n:
                res += s[j]
                if i != 0 and i != numRows - 1:
                    tmp = j + 2 * (numRows - i - 1)
                    if tmp < n:
                        res += s[tmp]
                j += 2 * (numRows - 1)
        return res