class Solution:
    def grayCode(self, n: int) -> List[int]:
        
        def grayCode(n):
            if n == 1:
                return [0, 1]
            else:
                prev = grayCode(n-1)
                return prev + [x + 2**(n-1) for x in reversed(prev)]
        return grayCode(n)