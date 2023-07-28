class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        x = y = di = 0
        result = 0
        obstacles = set(map(tuple, obstacles))
        for cmd in commands:
            if cmd == -2:
                di = (di - 1) % 4
            elif cmd == -1:
                di = (di + 1) % 4
            else:
                for k in range(cmd):
                    if (x + directions[di][0], y + directions[di][1]) not in obstacles:
                        x += directions[di][0]
                        y += directions[di][1]
                        result = max(result, x * x + y * y)
        return result