class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        l, r = 1, len(nums)
        while l <= r:
            k = (l + r) // 2
            if sum((num + k - 1) // k for num in nums) <= threshold:
                r = k - 1
            else:
                l = k + 1
        return l if l <= len(nums) else -1