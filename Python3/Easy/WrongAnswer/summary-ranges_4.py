class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        result = []
        if not nums:
            return result
        nums.append(2 ** 31)
        start = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1] + 1:
                if start == i - 1:
                    result.append(str(nums[start]))
                else:
                    result.append(str(nums[start]) + "->" + str(nums[i - 1]))
                start = i
        return result