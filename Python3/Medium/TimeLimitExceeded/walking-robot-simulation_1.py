class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        
        direction = 0
        cur_x = 0
        cur_y = 0
        max_dist = 0
        for cmd in commands:
            if cmd == -1:
                direction = (direction + 1) % 4
            elif cmd == -2:
                direction = (direction - 1) % 4
            else:
                for i in range(cmd):
                    if direction == 0:
                        cur_y += 1
                    elif direction == 1:
                        cur_x += 1
                    elif direction == 2:
                        cur_y -= 1
                    elif direction == 3:
                        cur_x -= 1
                    if [cur_x, cur_y] in obstacles:
                        if direction == 0:
                            cur_y -= 1
                        elif direction == 1:
                            cur_x -= 1
                        elif direction == 2:
                            cur_y += 1
                        elif direction == 3:
                            cur_x += 1
                        break
                max_dist = max(max_dist, cur_x**2 + cur_y**2)
        return max_dist