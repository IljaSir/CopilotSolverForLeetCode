class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        
        nums.sort()
        if nums[0] >= 0:
            return (nums[0] - value) // value + 1
        elif nums[-1] < 0:
            return (nums[-1] + value) // value + 1
        else:
            for i in range(len(nums) - 1):
                if nums[i] < 0 and nums[i + 1] >= 0:
                    return (nums[i] + value) // value + 1
            return 0