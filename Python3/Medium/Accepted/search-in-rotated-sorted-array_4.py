class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        n = len(nums)
        if n == 0:
            return -1
        if n == 1:
            return 0 if nums[0] == target else -1
        left, right = 0, n - 1
        while left <= right:
            pivot = left + (right - left) // 2
            if nums[pivot] == target:
                return pivot
            # the bottom half is sorted
            if nums[left] <= nums[pivot]:
                if nums[left] <= target < nums[pivot]:
                    right = pivot - 1
                else:
                    left = pivot + 1
            # the upper half is sorted
            else:
                if nums[pivot] < target <= nums[right]:
                    left = pivot + 1
                else:
                    right = pivot - 1
        return -1