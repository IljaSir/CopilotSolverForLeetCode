class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        
        def isConcatenation(nums, target):
            for i in range(len(target)):
                if target[:i+1] in nums and target[i+1:] in nums:
                    return True
            return False
        count = 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if isConcatenation([nums[i], nums[j]], target):
                    count += 1
        return count