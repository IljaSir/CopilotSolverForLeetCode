class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        # binary search
        def search(nums, target, start, end):
            if start > end:
                return -1
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            if nums[start] <= nums[mid]:
                if nums[start] <= target < nums[mid]:
                    return search(nums, target, start, mid - 1)
                else:
                    return search(nums, target, mid + 1, end)
            else:
                if nums[mid] < target <= nums[end]:
                    return search(nums, target, mid + 1, end)
                else:
                    return search(nums, target, start, mid - 1)

        return search(nums, target, 0, len(nums) - 1)