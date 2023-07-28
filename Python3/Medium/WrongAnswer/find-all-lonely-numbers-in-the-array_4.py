class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        
        lonely = []
        for i in range(len(nums)):
            if i == 0 and nums[i] != nums[i+1]:
                lonely.append(nums[i])
            elif i == len(nums) - 1 and nums[i] != nums[i-1]:
                lonely.append(nums[i])
            elif nums[i] != nums[i-1] and nums[i] != nums[i+1]:
                lonely.append(nums[i])
        return lonely