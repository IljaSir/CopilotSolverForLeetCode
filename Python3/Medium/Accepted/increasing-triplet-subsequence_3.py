class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        if len(nums) < 3:
            return False
        first = second = float('inf')
        for i in nums:
            if i <= first:
                first = i
            elif i <= second:
                second = i
            else:
                return True
        return False