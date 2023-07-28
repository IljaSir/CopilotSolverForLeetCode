class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        
        # Time  complexity: O(N + Q)
        # Space complexity: O(N + Q)
        prefixSum = [0]
        for candies in candiesCount:
            prefixSum.append(prefixSum[-1] + candies)

        ans = []
        for favoriteType, favoriteDay, dailyCap in queries:
            x1 = favoriteDay + 1
            y1 = (favoriteDay + 1) * dailyCap
            x2 = prefixSum[favoriteType] + 1
            y2 = prefixSum[favoriteType + 1]
            ans.append(not (x1 > y2 or y1 < x2))
        return ans