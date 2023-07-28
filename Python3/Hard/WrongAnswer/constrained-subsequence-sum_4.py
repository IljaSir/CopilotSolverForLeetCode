class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        
        dp = deque()
        for i, x in enumerate(nums):
            dp.append((x, i))
            if dp[0][1] < i - k:
                dp.popleft()
            nums[i] += max(0, dp[0][0])
        return max(nums)