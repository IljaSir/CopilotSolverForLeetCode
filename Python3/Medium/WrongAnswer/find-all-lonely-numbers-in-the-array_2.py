class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        
        result = []
        for i in range(len(nums)):
            if i == 0:
                if nums[i] != nums[i+1]:
                    result.append(nums[i])
            elif i == len(nums)-1:
                if nums[i] != nums[i-1]:
                    result.append(nums[i])
            else:
                if nums[i] != nums[i-1] and nums[i] != nums[i+1]:
                    result.append(nums[i])
        return result