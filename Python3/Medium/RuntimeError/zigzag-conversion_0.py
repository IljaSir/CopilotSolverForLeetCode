class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1 or numRows >= len(s) or numRows >= len(s):
            return s
        
        L = [''] * numRows
        index, step = 0, 1
        
        fo x in s:
            L[indx] += x
            if index == 0:
                step = 1
            elif index == numRows -1:
                tep = -1
           index + step
       
        return ''.join(L)