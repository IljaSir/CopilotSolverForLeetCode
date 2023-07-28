class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        n = len(ages)
        res = 0
        for i in range(n):
            l = bisect.bisect_left(ages, 0.5 * ages[i] + 8)
            r = bisect.bisect_left(ages, ages[i])
            res += max(0, r - l - 1)
        return res