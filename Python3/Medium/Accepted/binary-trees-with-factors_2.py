class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        dp = {}
        arr.sort()
        for i in range(len(arr)):
            dp[arr[i]] = 1
            for j in range(i):
                if arr[i] % arr[j] == 0 and arr[i] // arr[j] in dp:
                    dp[arr[i]] += dp[arr[j]] * dp[arr[i] // arr[j]]
        return sum(dp.values()) % (10 ** 9 + 7)