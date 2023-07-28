class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        if len(nums) < 3:
            return False
        else:
            a = nums[0]
            b = float('inf')
            for i in range(1, len(nums)):
                if nums[i] <= a:
                    a = nums[i]
                elif nums[i] <= b:
                    b = nums[i]
                else:
                    return True
            return False