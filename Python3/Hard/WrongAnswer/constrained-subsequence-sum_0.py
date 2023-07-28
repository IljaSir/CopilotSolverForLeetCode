class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        q = collections.deque([0])
        for i in range(1, len(nums)):
            dp[i] = max(dp[i], nums[i] + (dp[q[0]] if q else 0))
            while q and dp[q[-1]] < dp[i]:
                q.pop()
            q.append(i)
            if q[0] == i - k:
                q.popleft()
        return max(dp)