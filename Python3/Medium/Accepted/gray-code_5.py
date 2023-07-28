class Solution:
    def grayCode(self, n: int) -> List[int]:
        
        def gray(n):
            if n == 1:
                return ['0', '1']
            res = []
            for i in gray(n-1):
                res.append('0'+i)
            for i in gray(n-1)[::-1]:
                res.append('1'+i)
            return res
        return [int(i, 2) for i in gray(n)]