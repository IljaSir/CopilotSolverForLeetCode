class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        
        if len(nums) < 2:
            return False
        if len(nums) == 2:
            return nums[0] == nums[1]
        nums.sort()
        for i in range(0, len(nums), 2):
            if nums[i] != nums[i+1]:
                return False
        return True