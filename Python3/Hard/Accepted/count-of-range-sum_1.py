class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        def merge_sort(lo, hi):
            mid = (lo + hi) // 2
            if mid == lo:
                return 0
            count = merge_sort(lo, mid) + merge_sort(mid, hi)
            i = j = mid
            for left in pre[lo:mid]:
                while i < hi and pre[i] - left < lower: i += 1
                while j < hi and pre[j] - left <= upper: j += 1
                count += j - i
            pre[lo:hi] = sorted(pre[lo:hi])
            return count
        return merge_sort(0, n + 1)