class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        left_sum = [0]
        right_sum = [0]
        for i in range(len(nums)):
            left_sum.append(left_sum[-1] + nums[i])
            right_sum.append(right_sum[-1] + nums[-i - 1])
        right_sum = right_sum[::-1]
        return [abs(left_sum[i] - right_sum[i + 1]) for i in range(len(nums))]