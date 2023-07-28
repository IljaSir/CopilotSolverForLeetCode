class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        # O(n) time, O(1) space
        n = len(nums)
        l = 0
        r = 0
        ans = n+1
        s = 0
        while r < n:
            s += nums[r]
            while s >= target:
                ans = min(ans, r-l+1)
                s -= nums[l]
                l += 1
            r += 1
        if ans == n+1:
            return 0
        return ans