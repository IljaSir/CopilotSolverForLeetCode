class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        if not nums:
            return []
        if len(nums) == 1:
            return [str(nums[0])]
        result = []
        for i in range(len(nums)):
            if i == 0:
                current_range = [nums[i]]
                continue
            if nums[i] - nums[i - 1] == 1:
                current_range.append(nums[i])
            else:
                if len(current_range) == 1:
                    result.append(str(current_range[0]))
                else:
                    result.append(str(current_range[0]) + "->" + str(current_range[-1]))
                current_range = [nums[i]]
        if len(current_range) == 1:
            result.append(str(current_range[0]))
        else:
            result.append(str(current_range[0]) + "->" + str(current_range[-1]))
        return result