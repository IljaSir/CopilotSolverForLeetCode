class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        for i in range(len(nums)+1):
            for subset in itertools.combinations(nums, i):
                if sorted(subset) not in res:
                    res.append(sorted(subset))
        return res