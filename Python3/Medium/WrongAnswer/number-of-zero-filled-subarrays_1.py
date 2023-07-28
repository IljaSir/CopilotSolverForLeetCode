class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        
        total = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                total += 1
            else:
                for j in range(i+1, len(nums)):
                    if nums[j] == 0:
                        total += 1
                    else:
                        break
        return total