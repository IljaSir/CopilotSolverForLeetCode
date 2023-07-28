class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = [[]]
        for num in nums:
            res += [item + [num] for item in res if item + [num] not in res]
        return res