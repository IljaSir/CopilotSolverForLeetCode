class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        
        arr.sort()
        dp = {x: 1 for x in arr}
        for i in range(len(arr)):
            for j in range(i):
                if arr[i] % arr[j] == 0:
                    dp[arr[i]] += dp[arr[j]] * dp.get(arr[i] // arr[j], 0)
        return sum(dp.values()) % (10 ** 9 + 7)