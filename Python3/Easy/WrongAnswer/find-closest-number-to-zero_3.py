class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        closest = nums[0]
        for n in nums:
            if abs(n) > abs(closest):
                return closest
            elif abs(n) == abs(closest):
                closest = n
            else:
                continue
        return closest