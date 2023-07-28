class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        
        MOD = 10**9 + 7
        max_val = max(deliciousness)
        max_sum = max_val * 2
        pairs = 0
        count = collections.Counter(deliciousness)
        for val in count:
            i = 1
            while i <= max_sum:
                j = i - val
                if j in count:
                    if i == j * 2:
                        pairs += count[j] * (count[j] - 1) // 2
                    else:
                        pairs += count[j] * count[val]
                i *= 2
        return pairs % MOD