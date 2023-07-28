class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        n = len(s)
        res = [''] * numRows
        row, step = 0, 1
        for i in range(n):
            res[row] += s[i]
            if row == 0:
                step = 1
            elif row == numRows - 1:
                step = -1
            row += step
        return ''.join(res)