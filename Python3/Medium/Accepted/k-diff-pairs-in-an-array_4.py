class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        if k == 0:
            return len([x for x in set(nums) if nums.count(x) > 1])
        return len(set(nums) & set([x+k for x in nums]))