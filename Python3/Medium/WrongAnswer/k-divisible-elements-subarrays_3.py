class Solution:
    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # q, r = divmod(sum(nums), p)
        # dp = collections.Counter([0])
        # ans = 0
        # for x in nums:
        #     dp, r = collections.Counter((r + x) % p for r in dp), (r + x) % p
        #     ans += dp[q]
        #     if len(dp) > k:
        #         ans -= dp.popitem()[1]
        # return ans
        # Time  complexity: O(n)
        # Space complexity: O(n)
        q, r = divmod(sum(nums), p)
        dp = collections.defaultdict(collections.Counter)
        dp[0][0] = 1
        ans = 0
        for i, x in enumerate(nums):
            r = (r + x) % p
            dp[i + 1] = dp[i].copy()
            dp[i + 1][r] += 1
            ans += dp[i + 1][q]
            if i + 1 - k >= 0:
                ans -= dp[i + 1 - k].pop(r, 0)
        return ans