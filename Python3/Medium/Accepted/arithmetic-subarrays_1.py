class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def is_arithmetic(nums):
            nums.sort()
            d = nums[1] - nums[0]
            for i in range(2, len(nums)):
                if nums[i] - nums[i-1] != d:
                    return False
            return True
        return [is_arithmetic(nums[l[i]:r[i]+1]) for i in range(len(l))]