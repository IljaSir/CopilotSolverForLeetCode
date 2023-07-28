class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        n = len(ages)
        res = 0
        for i in range(n):
            if ages[i] < 15:
                continue
            j = i
            while j < n and ages[j] == ages[i]:
                j += 1
            res += (j - i) * (j - i - 1) // 2
            for k in range(j, n):
                if ages[k] <= 0.5 * ages[i] + 7:
                    continue
                if ages[k] > ages[i]:
                    break
                res += j - i
        return res