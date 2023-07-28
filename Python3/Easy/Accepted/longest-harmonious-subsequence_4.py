class Solution:
    def findLHS(self, nums: List[int]) -> int:
        result = 0
        dict_nums = {}
        for i in nums:
            dict_nums[i] = dict_nums.get(i, 0) + 1
        for i in dict_nums:
            if i + 1 in dict_nums:
                result = max(result, dict_nums[i] + dict_nums[i + 1])
        return result