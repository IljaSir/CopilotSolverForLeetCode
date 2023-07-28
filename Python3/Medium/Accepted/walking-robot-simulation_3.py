class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # 0: north, 1: east, 2: south, 3: west
        direction = 0
        # 0: x, 1: y
        position = [0, 0]
        obstacles = set(map(tuple, obstacles))
        max_distance = 0
        for command in commands:
            if command == -1:
                direction = (direction + 1) % 4
            elif command == -2:
                direction = (direction - 1) % 4
            else:
                for _ in range(command):
                    if direction == 0:
                        position[1] += 1
                    elif direction == 1:
                        position[0] += 1
                    elif direction == 2:
                        position[1] -= 1
                    else:
                        position[0] -= 1
                    if tuple(position) in obstacles:
                        if direction == 0:
                            position[1] -= 1
                        elif direction == 1:
                            position[0] -= 1
                        elif direction == 2:
                            position[1] += 1
                        else:
                            position[0] += 1
                        break
                max_distance = max(max_distance, position[0]**2 + position[1]**2)
        return max_distance