class Solution:
    def arrayChange(self, nums: List[int], operations: List[List[int]]) -> List[int]:
        
        # for each operation, replace the first value with the second value
        # return the final array
        for op in operations:
            nums[nums.index(op[0])] = op[1]
        return nums