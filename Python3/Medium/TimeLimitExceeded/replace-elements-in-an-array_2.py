class Solution:
    def arrayChange(self, nums: List[int], operations: List[List[int]]) -> List[int]:
        
        for i, j in operations:
            nums[nums.index(i)] = j
        return nums