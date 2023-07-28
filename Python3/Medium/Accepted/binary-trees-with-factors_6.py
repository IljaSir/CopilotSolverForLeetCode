class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        arr.sort()
        n = len(arr)
        dp = [1] * n
        d = {x: i for i, x in enumerate(arr)}
        for i in range(n):
            for j in range(i):
                if arr[i] % arr[j] == 0:
                    x = arr[i] // arr[j]
                    if x in d:
                        dp[i] += dp[j] * dp[d[x]]
        return sum(dp) % (10**9 + 7)