class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        n = len(s)
        res = ['' for _ in range(numRows)]
        row = 0
        flag = -1
        for i in range(n):
            res[row] += s[i]
            if row == 0 or row == numRows - 1:
                flag = -flag
            row += flag
        return ''.join(res)