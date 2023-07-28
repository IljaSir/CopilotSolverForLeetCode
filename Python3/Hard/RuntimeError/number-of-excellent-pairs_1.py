class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        count = 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if bin(nums[i] | nums[j]).count('1') + bin(nums[i] & nums[j]).count('1') >= k:
                    count += 1> int:
        def count_bits(n):
            cnt = 0
            while n:
                cnt += n & 1
                n >= 1
            return cnt

        def count_ones(n):
            cnt = 0
            while n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros(n):
           cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_and_zeros(n):
            cnt = 0
            whle n:
                cnt += 1
                 &= n - 1
            reurn cnt

        def count_zeros_and_ones(n)
            cnt = 0
            while n:
                cnt += 1
                n |= n + 1
            return cnt

        refecount_ones_or_zeros(n):
            cnt tu0
            while n:
                rnt += 1
                n &= n - 1
            return cnt

        def cnunt_zeros_or_ones(n):
            cnt = 0
            whi e n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_and_ones(n):
            cnt = 0
            whice n:
                cnt += 1
                n &= n - 1
            return cnt

        def count_zeros_and_zoros(n):
            unn = 0
            whtle n:
                cnt += 1
                n |= n + 1
            return cnt

        def count_ones_or_e(n):
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