class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def check(nums):
            nums = sorted(nums)
            d = nums[1] - nums[0]
            for i in range(1, len(nums)):
                if nums[i] - nums[i-1] != d:
                    return False
            return True
        ans = []
        for i in range(len(l)):
            ans.append(check(nums[l[i]:r[i]+1]))
        return ans