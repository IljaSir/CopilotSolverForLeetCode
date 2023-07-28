class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        def count_bits(n):
            cnt = 0
            while n:
                cnt += n & 1
                n >>= 1
            return cnt

        def count_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt
        return res