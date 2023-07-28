class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        
        # O(n) time and space
        # n = len(candiesCount)
        # prefix = [0] * (n + 1) # prefix[i] = sum(candiesCount[:i])
        # for i in range(n):
        #     prefix[i + 1] = prefix[i] + candiesCount[i]
        # ans = []
        # for favorite_type, favorite_day, daily_cap in queries:
        #     x1 = favorite_day + 1
        #     y1 = (favorite_day + 1) * daily_cap
        #     x2 = prefix[favorite_type] + 1
        #     y2 = prefix[favorite_type + 1]
        #     ans.append(not (x1 > y2 or y1 < x2))
        # return ans

        # O(n) time and space
        n = len(candiesCount)
        prefix = [0] * (n + 1)