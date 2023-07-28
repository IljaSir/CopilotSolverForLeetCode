class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        if n == 1:
            return 1
        if time <= n:
            return time
        time -= n
        if time % (n - 1) == 0:
            return n
        return time % (n - 1)