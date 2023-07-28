class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        return n - (time % (2 * n) - n) if time % (2 * n) > n else time % (2 * n)