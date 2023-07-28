class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        left_sum = 0
        right_sum = sum(nums)
        answer = []
        for i in range(len(nums)):
            right_sum -= nums[i]
            answer.append(abs(left_sum - right_sum))
            left_sum += nums[i]
        return answer