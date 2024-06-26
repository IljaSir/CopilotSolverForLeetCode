class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def search(nums, target, left):
            lo = 0
            hi = len(nums)
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] > target or (left and target == nums[mid]):
                    hi = mid
                else:
                    lo = mid + 1
            return lo

        left_idx = search(nums, target, True)

        if left_idx == len(nums) or nums[left_idx] != target:
            return [-1, -1]

        return [left_idx, search(nums, target, False)-1]