class Solution:
    def countCollisions(self, directions: str) -> int:
        
        collisions = 0
        moving = 0
        for direction in directions:
            if direction == 'R':
                collisions += moving
            elif direction == 'L':
                moving = 0
            else:
                moving += 1
        return collisions