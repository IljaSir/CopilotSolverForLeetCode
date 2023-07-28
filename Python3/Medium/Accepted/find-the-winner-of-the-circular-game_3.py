class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        
        circle = [i for i in range(1, n+1)]
        pos = 0
        while len(circle) > 1:
            pos = (pos + k - 1) % len(circle)
            circle.pop(pos)
        return circle[0]