class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        
        nums.sort()
        n = len(nums)
        if nums[0] >= value:
            return value
        if nums[-1] <= -value:
            return 0
        for i in range(n):
            if nums[i] > -value:
                if i == 0:
                    if nums[i] >= value:
                        return value
                    else:
                        return nums[i] - value
                if nums[i - 1] + value < nums[i] - value:
                    return nums[i - 1] + value
                else:
                    return nums[i] - value
        return nums[-1] + value