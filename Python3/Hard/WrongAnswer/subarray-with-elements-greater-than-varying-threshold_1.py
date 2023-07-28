class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        def isValid(k):
            s = sum(nums[:k])
            if s > threshold: return True
            for i in range(k, len(nums)):
                s = s - nums[i-k] + nums[i]
                if s > threshold: return True
            return False
        l, r = 1, len(nums)
        while l <= r:
            mid = (l+r)//2
            if isValid(mid):
                r = mid - 1
            else:
                l = mid + 1
        return l if l <= len(nums) else -1