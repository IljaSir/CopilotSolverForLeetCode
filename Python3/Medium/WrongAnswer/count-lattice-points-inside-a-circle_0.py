class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        
        
        # 1. get the max radius
        # 2. get the max distance from the center of the circle to the edge
        # 3. get the number of lattice points in the square
        # 4. for each circle, find the number of lattice points in the circle

        # 1. get the max radius
        max_radius = 0
        for circle in circles:
            max_radius = max(max_radius, circle[2])
        
        # 2. get the max distance from the center of the circle to the edge
        max_distance = 0
        for circle in circles:
            max_distance = max(max_distance, circle[2] + 0.5)
        
        # 3. get the number of lattice points in the square
        max_distance = int(max_distance)
        num_lattice_points = (max_distance * 2 + 1) ** 2
        
        # 4. for each circle, find the number of lattice points in the circle
        for circle in circles:
            x, y, r = circle
            num_lattice_points -= (r * 2 + 1) ** 2
            for i in range(x - r, x + r + 1):
                for j in range(y - r, y + r + 1):
                    if (i - x) ** 2 + (j - y) ** 2 > r ** 2:
                        num_lattice_points += 1
        
        return num_lattice_points