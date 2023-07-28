class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        # binary search
        # find pivot index
        # then binary search in each half
        # O(logn) runtime
        # O(1) space
        # check for empty list
        if len(nums) == 0:
            return -1
        # check for single element list
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
        # find pivot index
        pivot = self.find_pivot(nums)
        # binary search in each half
        if pivot == -1:
            return self.binary_search(nums, 0, len(nums) - 1, target)
        if nums[pivot] == target:
            return pivot
        if target >= nums[0]:
            return self.binary_search(nums, 0, pivot - 1, target)
        else:
            return self.binary_search(nums, pivot + 1, len(nums) - 1, target)