class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        n = str(n)
        for i in range(30):
            if sorted(str(1<<i)) == sorted(n):
                return True
        return False