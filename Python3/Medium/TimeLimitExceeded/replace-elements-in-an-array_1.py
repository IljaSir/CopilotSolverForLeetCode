class Solution:
    def arrayChange(self, nums: List[int], operations: List[List[int]]) -> List[int]:
        
        for i in operations:
            nums[nums.index(i[0])] = i[1]
        return nums