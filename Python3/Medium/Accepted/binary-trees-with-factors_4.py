class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        n = len(arr)
        arr.sort()
        dp = [1] * n
        idx = {x: i for i, x in enumerate(arr)}
        for i, x in enumerate(arr):
            for j in range(i):
                if x % arr[j] == 0:
                    right = x // arr[j]
                    if right in idx:
                        dp[i] += dp[j] * dp[idx[right]]
        return sum(dp) % (10**9 + 7)