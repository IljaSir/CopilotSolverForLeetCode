class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def check(nums):
            if len(nums) < 3:
                return True
            nums.sort()
            diff = nums[1] - nums[0]
            for i in range(2, len(nums)):
                if nums[i] - nums[i-1] != diff:
                    return False
            return True
        return [check(nums[i:j+1]) for i, j in zip(l, r)]