class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return min(nums[0], nums[1])
        else:
            mid = len(nums) // 2
            if nums[mid] > nums[-1]:
                return self.findMin(nums[mid:])
            else:
                return self.findMin(nums[:mid])