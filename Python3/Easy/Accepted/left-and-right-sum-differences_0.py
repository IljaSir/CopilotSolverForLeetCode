class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        leftSum = [0] * len(nums)
        rightSum = [0] * len(nums)
        for i in range(1, len(nums)):
            leftSum[i] = leftSum[i - 1] + nums[i - 1]
        for i in range(len(nums) - 2, -1, -1):
            rightSum[i] = rightSum[i + 1] + nums[i + 1]
        return [abs(leftSum[i] - rightSum[i]) for i in range(len(nums))]