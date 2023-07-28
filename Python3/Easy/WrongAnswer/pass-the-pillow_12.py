class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        return (time - 1) % (n - 1) + 1