class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        return (time - 1) % (2 * n - 2) + 1