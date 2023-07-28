class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        time = time % (n * 2 - 2)
        if time == 0:
            return n
        if time <= n:
            return time
        return 2 * n - time