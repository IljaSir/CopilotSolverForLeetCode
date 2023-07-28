class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        
        # 1. find the first index i > 0 where nums[i] > nums[i - 1]
        # 2. find the last index j < len(nums) - 1 where nums[j] < nums[j + 1]
        # 3. find the last index k < len(nums) - 1 where nums[k] < nums[k + 1]
        # 4. if i > j or j > k, return 0
        # 5. return k - j + 1
        pass