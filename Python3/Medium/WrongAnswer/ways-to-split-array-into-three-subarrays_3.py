class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        
        # 1st solution. 52ms, 74.85%
        # Time O(n), Space O(n)
        MOD = 10**9 + 7
        n = len(nums)
        pre_sum = [0] * (n + 1)
        for i in range(n):
            pre_sum[i + 1] = pre_sum[i] + nums[i]
        # print(pre_sum)
        res = 0
        for j in range(1, n):
            l, r = 0, j
            while l < r:
                mid = (l + r) // 2
                if pre_sum[mid] <= pre_sum[j] - pre_sum[mid]:
                    l = mid + 1
                else:
                    r = mid
            # print(l, r)
            if l == j: continue
            l, r = j, n
            while l < r:
                mid = (l + r) // 2
                if pre_sum[mid] - pre_sum[j] >= pre_sum[n] - pre_sum[mid]:
                    r = mid
                else:
                    l = mid + 1
            # print(l, r)
            res += max(l - j, 0)
        return res % MOD