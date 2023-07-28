class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1, -1]
        start = 0
        end = len(nums) - 1
        while start < end:
            mid = start + (end - start) // 2
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        if nums[start] != target:
            return [-1, -1]
        left = start
        end = len(nums) - 1
        while start < end:
            mid = start + (end - start) // 2 + 1
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid
        return [left, end]