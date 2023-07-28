class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        cnt = collections.Counter(nums)
        res = 0
        for num in cnt:
            for i in range(31):
                if (num >> i) & 1 == 0:
                    res += cnt.get(num | (1 << i), 0)
                elif k - i - 1 <= 0:
                    res += cnt.get(num & ~(1 << i), 0)

        def count_zeros(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_and_zeros(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_and_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_or_zeros(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_or_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_and_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_and_zeros(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_or_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_or_zeros(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_or_and(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_or_and(n):
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_and_or(n):
            cnt = 0
            while n:
                cnt += 1
                n