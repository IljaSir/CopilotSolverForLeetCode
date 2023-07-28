class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        def search_helper(nums, target, start, end):
            if start > end:
                return -1
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                return search_helper(nums, target, mid+1, end)
            else:
                return search_helper(nums, target, start, mid-1)
        return search_helper(nums, target, 0, len(nums)-1)