class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        d = collections.defaultdict(int)
        for n in nums:
            d[bin(n).count('1')] += 1
        res = 0
        for x, y in itertools.combinations_with_replacement(d, 2):
            if x + y >= k:
                res += d[x] * d[y]
        return res