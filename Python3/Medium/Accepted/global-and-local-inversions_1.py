class Solution:
    def isIdealPermutation(self, nums: List[int]) -> bool:
        
        mx = 0
        for i in range(len(nums)-2):
            mx = max(mx, nums[i])
            if mx > nums[i+2]:
                return False
        return True