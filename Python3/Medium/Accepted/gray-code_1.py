class Solution:
    def grayCode(self, n: int) -> List[int]:
        
        if n == 0:
            return [0]
        if n == 1:
            return [0, 1]
        else:
            return self.grayCode(n-1) + [2**(n-1) + i for i in self.grayCode(n-1)[::-1]]