class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows==1:
            return s
        rows=['']*numRows
        step=1
        count=0
        for i in s:
            rows[count]+=i
            if count==0:
                step=1
            elif count==numRows-1:
                step=-1
            count+=step
        return ''.join(rows)