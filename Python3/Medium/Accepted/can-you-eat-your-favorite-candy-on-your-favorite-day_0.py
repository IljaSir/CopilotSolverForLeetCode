class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        
        n = len(candiesCount)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + candiesCount[i]
        ans = []
        for favoriteType, favoriteDay, dailyCap in queries:
            min_day = favoriteDay + 1
            max_day = (favoriteDay + 1) * dailyCap
            min_candies = pre[favoriteType] + 1
            max_candies = pre[favoriteType + 1]
            ans.append(not (min_candies > max_day or max_candies < min_day))
        return ans