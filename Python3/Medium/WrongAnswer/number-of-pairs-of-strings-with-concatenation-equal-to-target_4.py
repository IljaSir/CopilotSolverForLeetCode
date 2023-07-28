class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        
        d = collections.defaultdict(int)
        res = 0
        for num in nums:
            d[num] += 1
        for num in nums:
            if target.startswith(num):
                res += d[target[len(num):]]
            if target.endswith(num):
                res += d[target[:-len(num)]]
            if target.startswith(num) and target.endswith(num):
                res -= 1
        return res // 2