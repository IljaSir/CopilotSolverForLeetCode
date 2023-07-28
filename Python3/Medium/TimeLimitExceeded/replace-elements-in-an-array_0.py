class Solution:
    def arrayChange(self, nums: List[int], operations: List[List[int]]) -> List[int]:
        
        for op in operations:
            nums[nums.index(op[0])] = op[1]
        return nums