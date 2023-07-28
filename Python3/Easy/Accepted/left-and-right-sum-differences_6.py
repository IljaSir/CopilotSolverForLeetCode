class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        leftSum = [0]
        rightSum = [0]
        for i in range(1, len(nums)):
            leftSum.append(leftSum[-1] + nums[i - 1])
            rightSum.append(rightSum[-1] + nums[-i])
        rightSum = rightSum[::-1]
        return [abs(leftSum[i] - rightSum[i]) for i in range(len(nums))]