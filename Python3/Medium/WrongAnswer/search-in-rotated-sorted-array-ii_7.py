class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        def binary_search(nums, target):
            l, r = 0, len(nums) - 1
            while l <= r:
                mid = l + (r - l) // 2
                if nums[mid] == target:
                    return True
                elif nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            return False

        def find_pivot(nums):
            l, r = 0, len(nums) - 1
            while l < r:
                mid = l + (r - l) // 2
                if nums[mid] > nums[r]:
                    l = mid + 1
                else:
                    r = mid
            return l

        if not nums: return False
        if len(nums) == 1: return nums[0] == target
        pivot = find_pivot(nums)
        if nums[pivot] == target: return True
        if pivot == 0: return binary_search(nums, target)
        if target >= nums[0]:
            return binary_search(nums[:pivot], target)
        else:
            return binary_search(nums[pivot:], target)