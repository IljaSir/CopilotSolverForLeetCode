class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        c = 0
        result = 0
        for i in nums:
            if i == 1:
                c += 1
                result = max(result, c)
            else:
                c = 0
        return result