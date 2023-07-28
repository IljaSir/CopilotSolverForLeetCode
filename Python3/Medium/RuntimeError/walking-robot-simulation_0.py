class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        x, y, dx, dy = 0, 0, 0, 1
        obstacleSet = set(map(tuple, obstacles))
        ans = 0
        for cmd in commands:
            if cmd == -2: