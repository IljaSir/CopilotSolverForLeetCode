class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # 1. define a direction list
        # 2. define a position list
        # 3. define a obstacle list
        # 4. define a max distance
        # 5. iterate the commands list
        # 6. update the position list based on the commands and direction
        # 7. update the direction list based on the commands
        # 8. update the max distance
        # 9. return the max distance
        
        # 1. define a direction list
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        # 2. define a position list
        position = [0, 0]
        # 3. define a obstacle list
        obstacles = set(map(tuple, obstacles))
        # 4. define a max distance
        max_distance = 0
        # 5. iterate the commands list
        for command in commands:
            # 6. update the position list based on the commands and direction
            if command == -1:
                directions = directions[1:] + directions[:1]
            elif command == -2:
                directions = directions[-1:] + directions[:-1]
            else:
                for _ in range(command):
                    position[0] += directions[0][0]
                    position[1] += directions[0][1]
                    if tuple(position) in obstacles:
                        position[0] -= directions[0][0]
                        position[1] -= directions[0][1]
                        break
            # 8. update the max distance
            max_distance = max(max_distance, position[0]**2 + position[1]**2)
        # 9. return the max distance
        return max_distance