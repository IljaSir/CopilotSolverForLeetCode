class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        
        # # 1. Brute Force
        # # Time  complexity: O(N^2)
        # # Space complexity: O(N)
        # # N = len(candiesCount)
        # prefix = [0] * (len(candiesCount) + 1)
        # for i in range(1, len(prefix)):
        #     prefix[i] = prefix[i - 1] + candiesCount[i - 1]
        # ans = []
        # for favoriteType, favoriteDay, dailyCap in queries:
        #     minCandies = prefix[favoriteType] + favoriteDay + 1
        #     maxCandies = prefix[favoriteType + 1] * dailyCap
        #     ans.append(minCandies <= maxCandies)
        # return ans

        # 2. Binary Search
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        # N = len(candiesCount)
        prefix = [0] * (len(candiesCount) + 1)
        for i in range(1, len(prefix)):
            prefix[i] = prefix[i - 1] + candiesCount[i - 1]
        ans = []
        for favoriteType, favoriteDay, dailyCap in queries:
            minCandies = prefix[favoriteType] + favoriteDay + 1
            maxCandies = prefix[favoriteType + 1] * dailyCap
            left, right = 0, len(prefix) - 1
            while left < right:
                mid = (left + right) // 2
                if prefix[mid] < minCandies:
                    left = mid + 1
                else:
                    right = mid
            minType = left
            left, right = 0, len(prefix) - 1
            while left < right:
                mid = (left + right) // 2
                if prefix[mid] <= maxCandies:
                    left = mid + 1
                else:
                    right = mid
            maxType = left
            ans.append(minType <= maxType <= favoriteType + 1)
        return ans