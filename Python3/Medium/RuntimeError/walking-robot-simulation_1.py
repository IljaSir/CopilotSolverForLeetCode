class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        x, y = 0, 0
        dx, dy = 0, 1
        ans = 0
        obstacles = set(map(tuple, obstacles))
        for cmd in commands:
            if cmd == -2: