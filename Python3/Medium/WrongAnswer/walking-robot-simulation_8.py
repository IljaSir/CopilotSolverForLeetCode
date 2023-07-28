class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        # 1. create a set of obstacles
        # 2. create a list of directions
        # 3. create a pointer to the direction
        # 4. create a pointer to the current location
        # 5. for each command
        # 5a. if command is a left or right turn, update direction pointer
        # 5b. if command is a forward move, update location pointer
        # 5c. if command is a move and there is an obstacle, do nothing
        # 6. return the distance from the origin to the location pointer squared
        
        # 1. create a set of obstacles
        obstacles = set(map(tuple, obstacles))
        
        # 2. create a list of directions
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        # 3. create a pointer to the direction
        direction = 0
        
        # 4. create a pointer to the current location
        location = [0, 0]
        
        # 5. for each command
        for command in commands:
            # 5a. if command is a left or right turn, update direction pointer
            if command == -1:
                direction = (direction + 1) % 4
            elif command == -2:
                direction = (direction + 3) % 4
            else:
                # 5b. if command is a forward move, update location pointer
                for _ in range(command):
                    # 5c. if command is a move and there is an obstacle, do nothing
                    if tuple(map(sum, zip(location, directions[direction]))) in obstacles:
                        break
                    location = list(map(sum, zip(location, directions[direction])))
        
        # 6. return the distance from the origin to the location pointer squared
        return location[0] ** 2 + location[1] ** 2