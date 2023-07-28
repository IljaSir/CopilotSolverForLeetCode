class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        N = len(nums)
        if N == 0:
            return 0
        # prefix sum
        prefix = [0] * (N + 1)
        for i in range(N):
            prefix[i + 1] = prefix[i] + nums[i]
        # merge sort
        def merge_sort(lo, hi):
            if lo == hi:
                return 0
            mid = (lo + hi) // 2
            ans = merge_sort(lo, mid) + merge_sort(mid + 1, hi)
            # merge
            i, l, r = lo, mid + 1, mid + 1
            while i <= mid:
                while l <= hi and prefix[l] - prefix[i] < lower:
                    l += 1
                while r <= hi and prefix[r] - prefix[i] <= upper:
                    r += 1
                ans += r - l
                i += 1
            # sort
            prefix[lo:hi + 1] = sorted(prefix[lo:hi + 1])
            return ans
        return merge_sort(0, N)