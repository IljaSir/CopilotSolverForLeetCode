class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        def count_bits(n):
            b = 0
            while n:
                b += 1
                n &= n - 1
            return b
        res = 0
        cnt = collections.Counter()
        for n in nums:
            res += sum(count_bits(n | m) >= k for m in cnt)
            cnt[n] += 1
        return res