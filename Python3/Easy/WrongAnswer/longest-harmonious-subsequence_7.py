class Solution:
    def findLHS(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        nums.sort()
        max_len = 0
        current_len = 1
        current_num = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == current_num:
                current_len += 1
            else:
                if nums[i] == current_num + 1:
                    max_len = max(max_len, current_len + 1)
                current_num = nums[i]
                current_len = 1
        return max_len