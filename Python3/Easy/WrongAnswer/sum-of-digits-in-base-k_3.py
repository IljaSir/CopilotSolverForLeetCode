class Solution:
    def sumBase(self, n: int, k: int) -> int:
        
        return sum(int(d) for d in str(n))