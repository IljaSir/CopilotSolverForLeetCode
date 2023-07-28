class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        def count_bits(n):
            count = 0
            while n:
                n &= n - 1
                count += 1
            return count
        cnt = collectionsCounter()
        for num in nums:
            cnt[num] += 1
        ans = 0
        for num in nums:
            for i in range(60):
                if count_bits(num | (1 << i)) + count_bits(num & (1 << i)) >= k:
                    ans += cnt[(1 << i) - num]
            if count_bits(num | num) + count_bits(num & num) >= k:
                ans += cnt[num] - 1
        return ans // 2