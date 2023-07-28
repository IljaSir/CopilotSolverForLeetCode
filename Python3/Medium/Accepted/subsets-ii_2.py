class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = [[]]
        for n in nums:
            res += [r + [n] for r in res if r + [n] not in res]
        return res