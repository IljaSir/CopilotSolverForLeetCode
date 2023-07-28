class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        def orientation(p, q, r):
            val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
            if val == 0: return 0
            return 1 if val > 0 else 2
        
        def distance(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
        
        n = len(trees)
        if n < 4: return trees
        trees.sort()
        hull = []
        for i in range(n):
            while len(hull) >= 2 and orientation(hull[-2], hull[-1], trees[i]) != 2:
                hull.pop()
            hull.append(trees[i])
        hull.pop()
        for i in range(n - 1, -1, -1):
            while len(hull) >= 2 and orientation(hull[-2], hull[-1], trees[i]) != 2:
                hull.pop()
            hull.append(trees[i])
        hull.pop()
        return list(set(map(tuple, hull)))