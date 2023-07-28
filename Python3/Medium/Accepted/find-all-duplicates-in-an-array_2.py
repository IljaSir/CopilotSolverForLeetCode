class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                d[nums[i]] += 1
            else:
                d[nums[i]] = 1
        return [key for key, value in d.items() if value == 2]