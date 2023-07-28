class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        n = len(nums)
        ans = 1
        total = 0
        l = 0
        for r in range(1, n):
            total += (nums[r] - nums[r-1]) * (r - l)
            while total > k:
                total -= nums[r] - nums[l]
                l += 1
            ans = max(ans, r - l + 1)
        return ans