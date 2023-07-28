class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        n = str(n)
        return any(sorted(n) == sorted(str(1 << i)) for i in range(31))