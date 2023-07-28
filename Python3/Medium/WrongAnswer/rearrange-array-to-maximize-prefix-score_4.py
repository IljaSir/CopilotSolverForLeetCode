class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        # 1. find the max value and the second max value
        # 2. find the max value's index
        # 3. find the second max value's index
        # 4. calculate the score
        # 5. return the score
        max_value = max(nums)
        max_index = nums.index(max_value)
        nums.pop(max_index)
        second_max_value = max(nums)
        second_max_index = nums.index(second_max_value)
        score = 0
        for i in range(len(nums)):
            if i == max_index:
                score += second_max_value
            elif i == second_max_index:
                score += max_value
            else:
                score += nums[i]
        return score