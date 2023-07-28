class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = [[]]
        for num in nums:
            res += [r + [num] for r in res if r + [num] not in res]
        return res