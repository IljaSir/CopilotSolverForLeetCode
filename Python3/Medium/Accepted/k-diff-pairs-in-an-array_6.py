class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        counter = collections.Counter(nums)
        if k == 0:
            return sum(value > 1 for value in counter.values())
        return sum(value + k in counter for value in counter)