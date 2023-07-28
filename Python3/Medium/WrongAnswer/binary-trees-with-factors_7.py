class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        arr.sort()
        dp = [1] * len(arr)
        mod = 10 ** 9 + 7
        for i in range(len(arr)):
            for j in range(i):
                if arr[i] % arr[j] == 0:
                    dp[i] += dp[j] * dp[bisect.bisect_left(arr, arr[i] // arr[j])] * (arr[i] // arr[j] != arr[j])
                    dp[i] %= mod
        return sum(dp) % mod