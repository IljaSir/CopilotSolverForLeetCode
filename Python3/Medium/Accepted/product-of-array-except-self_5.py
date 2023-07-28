class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        left = [1]*n
        right = [1]*n
        for i in range(1, n):
            left[i] = left[i-1]*nums[i-1]
            right[n-1-i] = right[n-i]*nums[n-i]
        return [left[i]*right[i] for i in range(n)]