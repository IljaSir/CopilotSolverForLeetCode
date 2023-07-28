class Solution:
    def findLHS(self, nums: List[int]) -> int:
        max_length = 0
        for i in range(len(nums)):
            count = 1
            for j in range(i + 1, len(nums)):
                if abs(nums[i] - nums[j]) <= 1:
                    count += 1
            max_length = max(max_length, count)
        return max_length