class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        if len(nums) < 3:
            return False
        min1 = min2 = float('inf')
        for n in nums:
            if n <= min1:
                min1 = n
            elif n <= min2:
                min2 = n
            else:
                return True
        return False