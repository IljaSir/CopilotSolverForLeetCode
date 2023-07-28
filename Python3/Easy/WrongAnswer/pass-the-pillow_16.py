class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        for i in range(n):
            if time == i:
                return i
            elif time == n + i:
                return n - i
            elif time == 2*n - i:
                return i