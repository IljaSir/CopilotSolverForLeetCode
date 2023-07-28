class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        # https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
        # https://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
        def orientation(p1, p2, p3):
            # https://www.geeksforgeeks.org/orientation-3-ordered-points/
            # https://www.geeksforgeeks.org/orientation-3-ordered-points/amp/
            # https://www.geeksforgeeks.org/orientation-3-ordered-points/amp/
            val = (p2[1] - p1[1]) * (p3[0] - p2[0]) - (p2[0] - p1[0]) * (p3[1] - p2[1])
            if val == 0:
                return 0