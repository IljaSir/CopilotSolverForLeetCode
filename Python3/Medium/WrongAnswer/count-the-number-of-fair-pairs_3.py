class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        
        d = collections.defaultdict(int)
        for i, n in enumerate(nums):
            d[n] += 1
        count = 0
        for i, n in enumerate(nums):
            for j in range(lower - n, upper - n + 1):
                if j in d:
                    count += d[j]
            if n in d and d[n] > 0:
                count -= 1
                d[n] -= 1
        return count // 2