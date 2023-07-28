class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        
        # 1. Find the next obstacle on each lane
        # 2. Find the minimum number of side jumps to avoid the obstacle
        # 3. Return the minimum number of side jumps to avoid all obstacles
        # 4. Find the next obstacle on each lane
        next_obstacle = [-1 for i in range(3)]
        for i in range(len(obstacles)-1, -1, -1):
            if obstacles[i] != 0:
                next_obstacle[obstacles[i]-1] = i
        # 2. Find the minimum number of side jumps to avoid the obstacle
        # 3. Return the minimum number of side jumps to avoid all obstacles
        return min(self.find_min_side_jumps(0, obstacles, next_obstacle), self.find_min_side_jumps(1, obstacles, next_obstacle), self.find_min_side_jumps(2, obstacles, next_obstacle))