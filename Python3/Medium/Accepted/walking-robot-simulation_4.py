class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # 0: north, 1: east, 2: south, 3: west
        direction = 0
        x, y = 0, 0
        max_dist = 0
        # obstacles = set(map(tuple, obstacles))
        obstacles = set(map(tuple, obstacles))
        print(obstacles)
        for cmd in commands:
            if cmd == -1:
                direction = (direction + 1) % 4
            elif cmd == -2:
                direction = (direction - 1) % 4
            else:
                for _ in range(cmd):
                    if direction == 0:
                        if (x, y+1) not in obstacles:
                            y += 1
                    elif direction == 1:
                        if (x+1, y) not in obstacles:
                            x += 1
                    elif direction == 2:
                        if (x, y-1) not in obstacles:
                            y -= 1
                    elif direction == 3:
                        if (x-1, y) not in obstacles:
                            x -= 1
                    max_dist = max(max_dist, x**2 + y**2)
        return max_dist