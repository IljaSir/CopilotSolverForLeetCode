class Solution:
    def gcdSort(self, nums: List[int]) -> bool:
        
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        def find(x):
            if x != uf[x]:
                uf[x] = find(uf[x])
            return uf[x]
        def union(x, y):
            uf[find(x)] = find(y)
        uf = list(range(100001))
        for i in range(2, 100001):
            for j in range(i * 2, 100001, i):
                union(i, j)
        groups = collections.defaultdict(list)
        for i, n in enumerate(nums):
            groups[find(n)].append(i)
        snums = sorted(nums)
        for i, n in enumerate(snums):
            if nums[i] != n and i not in groups[find(n)]:
                return False
        return True