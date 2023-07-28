class Solution:
    def countElements(self, nums: List[int]) -> int:
        
        count = 0
        for i in nums:
            if i-1 in nums and i+1 in nums:
                count += 1
        return count