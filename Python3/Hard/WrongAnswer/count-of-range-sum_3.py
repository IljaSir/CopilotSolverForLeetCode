class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        if not nums:
            return 0

        n = len(nums)
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + nums[i]

        def merge_sort(lo, hi):
            mid = (lo + hi) // 2
            if mid == lo:
                return int(lower <= prefix_sum[lo] <= upper)

            count = merge_sort(lo, mid) + merge_sort(mid, hi)

            i = j = mid
            for left in prefix_sum[lo:mid]:
                while i <= hi and prefix_sum[i] - left < lower:
                    i += 1
                while j <= hi and prefix_sum[j] - left <= upper:
                    j += 1
                count += j - i
            prefix_sum[lo:hi] = sorted(prefix_sum[lo:hi])
            return count

        return merge_sort(0, n)