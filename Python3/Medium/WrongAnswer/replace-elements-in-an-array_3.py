class Solution:
    def arrayChange(self, nums: List[int], operations: List[List[int]]) -> List[int]:
        
        nums.sort()
        for op in operations:
            nums.remove(op[0])
            nums.insert(bisect.bisect_left(nums, op[1]), op[1])
        return nums