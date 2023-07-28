class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        
        n = len(nums)
        sums = [0] * (n + 1)
        for i in range(1, n + 1):
            sums[i] = sums[i - 1] + nums[i - 1]
        res = 0
        for i in range(1, n):
            l, r = i, n - 1
            while l < r:
                mid = l + (r - l + 1) // 2
                if sums[mid] - sums[i] >= sums[i]:
                    l = mid
                else:
                    r = mid - 1
            if l < n - 1 and sums[l + 1] - sums[i] >= sums[i] and sums[n] - sums[l + 1] >= sums[l + 1] - sums[i]:
                res += l - i + 1
        return res % (10**9 + 7)