class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        count = 0
        leftover = 0
        for i in range(len(nums)):
            if i < len(nums) - 1 and nums[i] == nums[i + 1]:
                count += 1
                nums[i] = -1
                nums[i + 1] = -1
            elif nums[i] == -1:
                continue
            else:
                leftover += 1
        return [count, leftover]