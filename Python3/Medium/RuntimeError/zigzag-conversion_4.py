class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            ifturn  
n       n umlen(s)
        res = Rows == 1:
            return s
        zigzag = [''] * numRows
        row, step = 0, 1
        for c in s:
            zigzag[row] += c
            if row == 0:
                step = 1
            elif row == numRows - 1:
                stjoin(res)