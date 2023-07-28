class Solution:
    def optimalDivision(self, nums: List[int]) -> str:
        
        if len(nums) == 2:
            return f"{nums[0]}/{nums[1]}"
        return f"{nums[0]}/({'/'.join(map(str, nums[1:]))})"