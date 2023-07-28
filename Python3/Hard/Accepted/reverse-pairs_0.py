class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge_sort(nums, start, end):
            if start >= end:
                return 0
            mid = (start + end) // 2
            count = merge_sort(nums, start, mid) + merge_sort(nums, mid + 1, end)
            p, q = start, mid + 1
            while p <= mid:
                while q <= end and nums[p] > 2 * nums[q]:
                    q += 1
                count += q - mid - 1
                p += 1
            nums[start:end + 1] = sorted(nums[start:end + 1])
            return count
        return merge_sort(nums, 0, len(nums) - 1)