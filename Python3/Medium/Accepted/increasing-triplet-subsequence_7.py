class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        # O(n) time and O(1) space
        # 2 pointer approach
        # 1. find the first element
        # 2. find the second element
        # 3. find the third element
        # 4. return true if third element found
        if len(nums) < 3:
            return False
        first = second = float('inf')
        for num in nums:
            if num <= first:
                first = num
            elif num <= second:
                second = num
            else:
                return True
        return False