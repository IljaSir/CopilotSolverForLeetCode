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
        return res