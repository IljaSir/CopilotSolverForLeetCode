class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        
        # O(n) time
        # O(k) space
        # dp[i] = max(dp[i-k], dp[i-k+1], ..., dp[i-1]) + nums[i]
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        q = collections.deque([0])
        for i in range(1, n):
            while q and q[0] < i - k:
                q.popleft()
            dp[i] = dp[q[0]] + nums[i]
            while q and dp[q[-1]] < dp[i]:
                q.pop()
            q.append(i)
        return dp[-1]