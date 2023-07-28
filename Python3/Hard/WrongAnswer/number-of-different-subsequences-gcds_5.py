class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        nums = set(nums)
        n = max(nums)
        cnt = [0] * (n + 1)
        for num in nums:
            cnt[num] += 1
        for i in range(1, n + 1):
            for j in range(i + i, n + 1, i):
                cnt[i] += cnt[j]
        ans = 0
        for i in range(1, n + 1):
            if cnt[i] > 0 and n // i == n / i:
                ans += 1
        return ans