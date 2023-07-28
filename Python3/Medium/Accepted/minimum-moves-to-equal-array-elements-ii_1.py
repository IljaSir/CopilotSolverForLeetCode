class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        
        nums.sort()
        i = 0
        j = len(nums) - 1
        result = 0
        while i < j:
            result += nums[j] - nums[i]
            i += 1
            j -= 1
        return result