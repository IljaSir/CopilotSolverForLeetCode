class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        arr.sort()
        n = len(arr)
        dp = [1] * n
        index = {x: i for i, x in enumerate(arr)}
        for i, x in enumerate(arr):
            for j in range(i):
                if x % arr[j] == 0:
                    right = x / arr[j]
                    if right in index:
                        dp[i] += dp[j] * dp[index[right]]
        return sum(dp) % (10**9 + 7)