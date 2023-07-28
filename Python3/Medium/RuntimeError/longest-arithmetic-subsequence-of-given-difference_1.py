class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        
        # dp[i] -> longest subsequence ending with arr[i]
        # dp[i] = dp[i-difference] + 1 if arr[i] - arr[i-difference] == difference else 1
        dp = [1] * len(arr)
        for i in range(1, len(arr)):
            if arr[i] - arr[i-difference] == difference:
                dp[i] = dp[i-difference] + 1
        return max(dp)