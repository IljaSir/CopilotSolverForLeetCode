class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        elif k == 0:
            return len([x for x in collections.Counter(nums).values() if x > 1])
        else:
            return len(set(nums) & set([x + k for x in nums]))