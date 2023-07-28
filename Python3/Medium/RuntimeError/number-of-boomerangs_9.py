class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        # 1. Brute Force
        # Time  complexity: O(N^3)
        # Space complexity: O(1)
        # res = 0
        # for i in range(len(points)):
        #     for j in range(len(points)):
        #         if i == j: continue
        #         for k in range(len(points)):
        #             if i == k or j == k: continue
        #             if self.get_distance(points[i], points[j]) == self.get_distance(points[i], points[k]):
        #                 res += 1
        # return res
        
        # 2. Hash Map
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        res = 0
        for i in range(len(points)):
            d = collections.defaultdict(int)
            for j in range(len(points)):
                if i == j: continue
                d[self.get_distance(points[i], points[j])] += 1
            for v in d.values():
                res += v * (v - 1)
        return res