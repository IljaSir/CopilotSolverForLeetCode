class Solution:
    def sumBase(self, n: int, k: int) -> int:
        
        return sum(int(x) for x in str(n))