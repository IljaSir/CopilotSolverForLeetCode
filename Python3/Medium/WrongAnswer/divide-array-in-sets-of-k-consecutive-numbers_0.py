class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        
        if len(nums) % k != 0:
            return False
        nums.sort()
        for i in range(0, len(nums), k):
            if nums[i:i+k] != list(range(nums[i], nums[i]+k)):
                return False
        return True