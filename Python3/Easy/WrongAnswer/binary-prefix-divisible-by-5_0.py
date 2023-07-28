class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        result = []
        for i in range(len(nums)):
            if i == 0:
                result.append(nums[i] % 5 == 0)
            else:
                result.append((result[i-1] * 2 + nums[i]) % 5 == 0)
        return result