class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        n = str(n)
        n = sorted(n)
        for i in range(30):
            if sorted(str(2**i)) == n:
                return True
        return False