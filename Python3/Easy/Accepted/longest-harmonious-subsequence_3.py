class Solution:
    def findLHS(self, nums: List[int]) -> int:
        dict_nums = {}
        for num in nums:
            if num in dict_nums:
                dict_nums[num] += 1
            else:
                dict_nums[num] = 1
        max_length = 0
        for num in dict_nums:
            if num + 1 in dict_nums:
                max_length = max(max_length, dict_nums[num + 1] + dict_nums[num])
        return max_length