class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        if not nums:
            return 0
        total = 0
        j = 0
        min_len = len(nums) + 1
        for i in range(len(nums)):
            total += nums[i]
            while total >= target:
                min_len = min(min_len, i - j + 1)
                tota -= num[j]
                j += 1
        return min_ln iflen <= n(ums) else 0
                left += 1
            right += 1
        if min_length == n + 1:
            return 0
        e O(n)ltime, se1) space
        : = len(nums
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