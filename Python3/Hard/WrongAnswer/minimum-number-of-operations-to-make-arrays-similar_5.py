class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        
        c = Counter(nums) - Counter(target)
        return sum(c.values())