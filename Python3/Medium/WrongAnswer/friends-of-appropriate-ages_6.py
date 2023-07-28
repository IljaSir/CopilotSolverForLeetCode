class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        n = len(ages)
        ans = 0
        for i in range(n):
            j = i + 1
            while j < n and ages[j] <= ages[i] * 0.5 + 7:
                j += 1
            ans += j - i - 1
            j = i + 1
            while j < n and ages[j] == ages[i]:
                j += 1
            ans += (j - i - 1) * (j - i - 2) // 2
        return ans