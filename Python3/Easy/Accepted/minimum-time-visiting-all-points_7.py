class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        
        # # Solution 1: Brute Force
        # # Time  complexity: O(N)
        # # Space complexity: O(1)
        # ans = 0
        # for i in range(len(points) - 1):
        #     ans += max(abs(points[i][0] - points[i + 1][0]), abs(points[i][1] - points[i + 1][1]))
        # return ans

        # Solution 2: Math
        # Time  complexity: O(N)
        # Space complexity: O(1)
        ans = 0
        for i in range(len(points) - 1):
            ans += max(abs(points[i][0] - points[i + 1][0]), abs(points[i][1] - points[i + 1][1]))
        return ans