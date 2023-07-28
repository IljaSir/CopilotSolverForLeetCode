class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        
        if k == 0:
            return True
        if len(nums) == 1:
            return True
        if len(nums) == 2:
            if nums[0] == 1 and nums[1] == 1:
                return False
            else:
                return True
        if nums[0] == 1:
            if nums[1] == 1:
                return False
            else:
                return self.kLengthApart(nums[2:], k)
        else:
            return self.kLengthApart(nums[1:], k)