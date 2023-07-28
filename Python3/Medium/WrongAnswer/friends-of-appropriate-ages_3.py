class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        n = len(ages)
        i = 0
        j = 0
        res = 0
        while i < n:
            while j < n and ages[j] <= 0.5 * ages[i] + 7:
                j += 1
            res += j - i - 1
            i += 1
            while i < n and ages[i] == ages[i - 1]:
                res += j - i
                i += 1
        return res