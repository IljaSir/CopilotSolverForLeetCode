class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        def ccw(A, B, C):
            return (C[1] - A[1]) * (B[0] - A[0]) > (B[1] - A[1]) * (C[0] - A[0])
        
        def convex_hull(trees):
            trees.sort()
            upper = []
            for t in trees:
                while len(upper) > 1 and not ccw(upper[-2], upper[-1], t):
                    upper.pop()
                upper.append(t)
            lower = []
            for t in reversed(trees):
                while len(lower) > 1 and not ccw(lower[-2], lower[-1], t):
                    lower.pop()
                lower.append(t)
            return set(upper[:-1] + lower[:-1])
        
        return list(convex_hull(trees))