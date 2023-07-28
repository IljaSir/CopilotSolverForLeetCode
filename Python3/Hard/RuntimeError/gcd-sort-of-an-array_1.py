class Solution:
    def gcdSort(self, nums: List[int]) -> bool:
        
        n = len(nums)
        p = [i for i in range(n+1)]
        def find(x):
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        def union(x, y):
            p[find(x)] = find(y)
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        for i in range(n):
            for j in range(i+1, n):
                if gcd(nums[i], nums[j]) > 1:
                    union(i, j)
        nums_sort = sorted(nums)
        for i in range(n):
            if find(nums_sort[i]-1) != find(nums[i]-1):
                return False
        return True