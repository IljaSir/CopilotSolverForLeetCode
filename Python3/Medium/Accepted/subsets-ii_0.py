class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        ans = [[]]
        for n in sorted(nums):
            ans += [a + [n] for a in ans if a + [n] not in ans]
        return ans