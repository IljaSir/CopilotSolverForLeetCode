class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        if not nums:
            return []
        if len(nums) == 1:
            return [str(nums[0])]
        result = []
        start = 0
        end = 0
        while end < len(nums):
            if end == len(nums) - 1:
                if nums[end] - nums[end - 1] == 1:
                    result.append(str(nums[start]) + "->" + str(nums[end]))
                else:
                    result.append(str(nums[start]))
                    result.append(str(nums[end]))
                break
            if nums[end + 1] - nums[end] == 1:
                end += 1
            else:
                if start == end:
                    result.append(str(nums[start]))
                else:
                    result.append(str(nums[start]) + "->" + str(nums[end]))
                start = end + 1
                end += 1
        return result