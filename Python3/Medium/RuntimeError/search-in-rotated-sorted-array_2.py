class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
        if len(nums) == 2:
            if nums[0] == target:
                return 0
            elif nums[1] == target:
                return 1
            else:
                return -1
        if nums[0] < nums[-1]:
            return self.binary_search(nums, target)
        else:
            pivot_index = self.find_pivot(nums)
            if nums[pivot_index] == target:
                return pivot_index
            elif nums[0] <= target:
                return self.binary_search(nums[:pivot_index], target)
            else:
                result = self.binary_search(nums[pivot_index:], target)
                if result == -1:
                    return result
                else:
                    return result + pivot_index