class Solution:
    def largestComponentSize(self, nums: List[int]) -> int:
        
        def find(x):
            if x != uf[x]:
                uf[x] = find(uf[x])
            return uf[x]
        def union(x, y):
            uf[find(x)] = find(y)
        
        uf = {x: x for x in nums}
        for x in nums:
            for i in range(2, int(x**0.5)+1):
                if x % i == 0:
                    union(x, i)
                    union(x, x//i)
        
        count = collections.Counter(find(x) for x in nums)
        return max(count.values())