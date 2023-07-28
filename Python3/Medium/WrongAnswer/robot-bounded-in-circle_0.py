class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        # x, y, direction = 0, 0, 0 # 0: north, 1: east, 2: south, 3: west
        # for i in instructions:
        #     if i == 'G':
        #         if direction == 0:
        #             y += 1
        #         elif direction == 1:
        #             x += 1
        #         elif direction == 2:
        #             y -= 1
        #         else:
        #             x -= 1
        #     elif i == 'L':
        #         direction = (direction + 3) % 4
        #     else:
        #         direction = (direction + 1) % 4
        # return (x, y) == (0, 0) or direction != 0
        x, y, direction = 0, 0, 0