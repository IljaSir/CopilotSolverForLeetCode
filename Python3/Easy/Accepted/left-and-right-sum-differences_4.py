class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        leftSum = [0]
        rightSum = [0]
        for i in range(1, len(nums)):
            leftSum.append(leftSum[i-1] + nums[i-1])
            rightSum.append(rightSum[i-1] + nums[len(nums) - i])
        rightSum.reverse()
        answer = [abs(leftSum[i] - rightSum[i]) for i in range(len(nums))]
        return answer