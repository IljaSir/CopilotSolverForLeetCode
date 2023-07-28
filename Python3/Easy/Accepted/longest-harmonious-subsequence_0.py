class Solution:
    def findLHS(self, nums: List[int]) -> int:
        count = collections.Counter(nums)
        return max([count[n] + count[n + 1] for n in count if n + 1 in count] or [0])