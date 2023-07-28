class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        if k == 0:
            return len([k for k,v in collections.Counter(nums).items() if v > 1])
        return len(set(nums) & set(n+k for n in nums))