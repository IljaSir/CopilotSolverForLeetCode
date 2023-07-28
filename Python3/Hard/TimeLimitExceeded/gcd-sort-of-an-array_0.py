class Solution:
    def gcdSort(self, nums: List[int]) -> bool:
        
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        def union(a, b):
            parent[find(a)] = find(b)
        n = len(nums)
        parent = list(range(10**5 + 1))
        for x in nums:
            for i in range(2, int(x**0.5) + 1):
                if x % i == 0:
                    union(i, x)
                    union(x, x // i)
        groups = collections.defaultdict(list)
        for i, x in enumerate(nums):
            groups[find(x)].append(i)
        sorted_nums = sorted(nums)
        for i, x in enumerate(sorted_nums):
            if i not in groups[find(x)]:
                return False
        return True