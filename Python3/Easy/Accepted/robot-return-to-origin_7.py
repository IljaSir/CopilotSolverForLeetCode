class Solution:
    def judgeCircle(self, moves: str) -> bool:
        
        # 4/18/2021
        # 36 ms	14.4 MB
        # O(n) time, O(1) space
        x = 0
        y = 0
        for move in moves:
            if move == "U":
                y += 1
            elif move == "D":
                y -= 1
            elif move == "L":
                x -= 1
            elif move == "R":
                x += 1
        return x == 0 and y == 0