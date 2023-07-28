class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # directions: 0, 1, 2, 3 (N, E, S, W)
        # x, y
        # (0, 1), (1, 0), (0, -1), (-1, 0)
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        x, y = 0, 0
        direction = 0
        obstacles = set(map(tuple, obstacles))
        ans = 0
        for command in commands:
            if command == -2:
                direction = (direction - 1) % 4
            elif command == -1:
                direction = (direction + 1) % 4
            else:
                for _ in range(command):
                    nx, ny = x + directions[direction][0], y + directions[direction][1]
                    if (nx, ny) in obstacles:
                        break
                    x, y = nx, ny
                    ans = max(ans, x*x + y*y)
        return ans