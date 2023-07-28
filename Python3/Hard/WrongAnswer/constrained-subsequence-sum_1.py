class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        q = collections.deque([0])
        res = dp[0]
        for i in range(1, n):
            if q[0] < i - k:
                q.popleft()
            dp[i] = max(dp[i], nums[i] + dp[q[0]])
            while q and dp[i] >= dp[q[-1]]:
                q.pop()
            q.append(i)
            res = max(res, dp[i])
        return res