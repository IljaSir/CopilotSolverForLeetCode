class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def search(nums, target, lower):
            left, right = 0, len(nums) - 1
            ans = len(nums)
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > target or (lower and target == nums[mid]):
                    right = mid - 1
                    ans = mid
                else:
                    left = mid + 1
            return ans

        left_idx = search(nums, target, True)
        right_idx = search(nums, target, False) - 1
        if left_idx <= right_idx and right_idx < len(nums) and nums[left_idx] == target and nums[right_idx] == target:
            return [left_idx, right_idx]
        return [-1, -1]