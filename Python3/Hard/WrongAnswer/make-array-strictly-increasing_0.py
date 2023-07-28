class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        
        # dp[i][j] = min number of changes to make arr1[:i] strictly increasing
        # if arr1[i] is replaced with arr2[j]
        dp = [[float('inf')] * len(arr2) for _ in range(len(arr1))]
        arr2.sort()
        def get_next(arr, num):
            if num >= arr[-1]:
                return float('inf')
            l, r = 0, len(arr) - 1
            while l < r:
                m = (l + r) // 2
                if arr[m] > num:
                    r = m
                else:
                    l = m + 1
            return arr[l]
        for i, n1 in enumerate(arr1):
            for j, n2 in enumerate(arr2):
                if n2 > n1:
                    if i == 0:
                        dp[i][j] = 1
                    else:
                        for k in range(len(arr2)):
                            if arr2[k] < arr1[i - 1]:
                                continue
                            dp[i][j] = min(dp[i][j], dp[i - 1][k] + (k != j))
                elif n2 == n1:
                    if i == 0:
                        dp[i][j] = 0
                    else:
                        for k in range(len(arr2)):
                            if arr2[k] < arr1[i - 1]:
                                continue
                            dp[i][j] = min(dp[i][j], dp[i - 1][k])
        res = min(dp[-1])
        if res == float('inf'):
            return -1
        return res