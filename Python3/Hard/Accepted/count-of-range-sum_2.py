class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]
        def merge_sort(l, r):
            if l == r:
                return 0
            m = (l + r) >> 1
            ret = merge_sort(l, m) + merge_sort(m + 1, r)
            i = j = m + 1
            for left in prefix[l:m + 1]:
                while i <= r and prefix[i] - left < lower:
                    i += 1
                while j <= r and prefix[j] - left <= upper:
                    j += 1
                ret += j - i
            prefix[l:r + 1] = sorted(prefix[l:r + 1])
            return ret
        return merge_sort(0, n)