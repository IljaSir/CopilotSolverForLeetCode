class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        
        n = len(nums)
        pre = [0] * n
        pre[0] = nums[0]
        for i in range(1, n):
            pre[i] = pre[i - 1] + nums[i]
        ans = 0
        for i in range(1, n):
            ans = max(ans, (pre[i] + i - 1) // i - (pre[n - 1] - pre[i - 1] + n - i - 1) // (n - i))
        return ans