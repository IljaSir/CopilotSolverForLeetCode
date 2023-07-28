class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        leftsum = nums[:]
        rightsum = nums[:]
        for i in range(1, len(nums)):
            leftsum[i] += leftsum[i - 1]
            rightsum[len(nums) - 1 - i] += rightsum[len(nums) - i]
        ans = []
        for i in range(len(nums)):
            if i == 0:
                ans.append(abs(0 - rightsum[i + 1]))
            elif i == len(nums) - 1:
                ans.append(abs(leftsum[i - 1] - 0))
            else:
                ans.append(abs(leftsum[i - 1] - rightsum[i + 1]))
        return ans