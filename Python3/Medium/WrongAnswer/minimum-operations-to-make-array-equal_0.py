class Solution:
    def minOperations(self, n: int) -> int:
        
        
        if n == 1:
            return 0
        
        if n % 2 == 0:
            return int(n * (n/2) / 2)
        else:
            return int((n-1) * (n/2) / 2)