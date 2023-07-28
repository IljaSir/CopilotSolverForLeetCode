class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        
        def rev(x):
            return int(str(x)[::-1])
        d = {}
        for n in nums:
            r = rev(n)
            d[n-r] = d.get(n-r, 0) + 1
        return sum([v*(v-1)//2 for v in d.values()]) % (10**9+7)