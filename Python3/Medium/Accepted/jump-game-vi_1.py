class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        
        # # 1. Dynamic Programming
        # # Time  complexity: O(n * k)
        # # Space complexity: O(n)
        # n = len(nums)
        # dp = [nums[0]] + [-float('inf')] * (n - 1)
        # for i in range(n):
        #     for j in range(1, k + 1):
        #         if i + j < n:
        #             dp[i + j] = max(dp[i + j], dp[i] + nums[i + j])
        # return dp[-1]

        # 2. Dynamic Programming
        # Time  complexity: O(n)
        # Space complexity: O(n)
        n = len(nums)
        dp = [nums[0]] + [-float('inf')] * (n - 1)
        q = collections.deque([0])
        for i in range(1, n):
            dp[i] = dp[q[0]] + nums[i]
            while q and dp[i] >= dp[q[-1]]:
                q.pop()
            q.append(i)
            if q[0] == i - k:
                q.popleft()
        return dp[-1]