class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge_sort(lo, hi):
            if lo >= hi:
                return 0
            mid = (lo + hi) // 2
            cnt = merge_sort(lo, mid) + merge_sort(mid + 1, hi)
            i = j = mid + 1
            for left in nums[lo:mid + 1]:
                while i <= hi and left > 2 * nums[i]:
                    i += 1
                while j <= hi and left >= nums[j]:
                    j += 1
                cnt += j - (mid + 1)
            nums[lo:hi + 1] = sorted(nums[lo:hi + 1])
            return cnt
        return merge_sort(0, len(nums) - 1)