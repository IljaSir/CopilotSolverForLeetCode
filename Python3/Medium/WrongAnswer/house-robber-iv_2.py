class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        
        def check(capability):
            # check if we can rob at least k houses with capability
            dp = [0] * (len(nums) + 1)
            for i in range(len(nums)):
                if nums[i] > capability:
                    dp[i + 1] = dp[i]
                else:
                    dp[i + 1] = max(dp[i], dp[i - 1] + nums[i])
            return dp[len(nums)] >= k * capability

        l, r = min(nums), sum(nums)
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l