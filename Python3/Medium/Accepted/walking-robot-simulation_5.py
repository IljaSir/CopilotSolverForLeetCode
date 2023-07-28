class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # 1. init
        direction = 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        obstacles = set(map(tuple, obstacles))
        pos = [0, 0]
        max_dist = 0
        # 2. loop
        for cmd in commands:
            if cmd == -1:
                direction = (direction + 1) % 4
            elif cmd == -2:
                direction = (direction - 1) % 4
            else:
                for _ in range(cmd):
                    new_pos = [pos[0] + directions[direction][0], pos[1] + directions[direction][1]]
                    if tuple(new_pos) not in obstacles:
                        pos = new_pos
                        max_dist = max(max_dist, pos[0] ** 2 + pos[1] ** 2)
        return max_dist