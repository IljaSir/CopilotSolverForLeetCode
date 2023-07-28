class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        if not ages:
            return 0
        ages.sort()
        n = len(ages)
        i, j = 0, 0
        res = 0
        while i < n:
            j = max(j, i)
            while j < n and ages[j] <= 0.5 * ages[i] + 7:
                j += 1
            res += j - i - 1
            i += 1
        i, j = 0, 0
        while i < n:
            j = max(j, i)
            while j < n and ages[j] == ages[i]:
                j += 1
            res += (j - i) * (j - i - 1) // 2
            i = j
        return res