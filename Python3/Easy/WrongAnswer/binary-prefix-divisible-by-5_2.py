class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        output = []
        for i in range(len(nums)):
            if i == 0:
                output.append(nums[i] % 5 == 0)
            else:
                output.append((output[i-1]*2 + nums[i]) % 5 == 0)
        return output