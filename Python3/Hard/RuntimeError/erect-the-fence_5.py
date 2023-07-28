class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        trees.sort()
        def cross(o, a, b):
            return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
        upper = []
        for t in trees:
            while len(upper) >= 2 and cross(upper[-2], upper[-1], t) > 0:
                upper.pop()
            upper.append(t)
        lower = []
        for t in reversed(trees):
            while len(lower) >= 2 and cross(lower[-2], lower[-1], t) > 0:
                lower.pop()
            lower.append(t)
        return list(set(upper + lower))