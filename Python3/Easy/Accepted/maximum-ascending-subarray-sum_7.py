class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        
        max_sum = 0
        current_sum = 0
        last_num = -1
        for num in nums:
            if num > last_num:
                current_sum += num
            else:
                max_sum = max(max_sum, current_sum)
                current_sum = num
            last_num = num
        return max(max_sum, current_sum)