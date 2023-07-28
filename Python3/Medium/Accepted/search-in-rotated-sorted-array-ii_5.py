class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        if not nums:
            return False
        if len(nums) == 1:
            return nums[0] == target
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return True
            if nums[mid] == nums[l] == nums[r]:
                l += 1
                r -= 1
            elif nums[mid] <= nums[r]:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
        return False