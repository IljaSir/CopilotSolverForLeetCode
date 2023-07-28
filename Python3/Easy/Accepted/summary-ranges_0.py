class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [str(nums[0])]
        result = []
        start = nums[0]
        for i in range(1, len(nums)):
            if nums[i] - nums[i-1] > 1:
                result.append(str(start) + '->' + str(nums[i-1]) if start != nums[i-1] else str(start))
                start = nums[i]
        result.append(str(start) + '->' + str(nums[-1]) if start != nums[-1] else str(start))
        return result