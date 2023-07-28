class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        def check(n):
            return sorted(str(n)) == sorted(str(1 << i))
        return any(check(n) for i in range(31))