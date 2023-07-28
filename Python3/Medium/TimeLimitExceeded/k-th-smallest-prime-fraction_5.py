class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        n = len(arr)
        def count(x):
            j = 1
            ans = 0
            for i in range(n-1):
                while j < n and arr[i] > x * arr[j]:
                    j += 1
                ans += n - j
            return ans
        l, r = 0, 1
        while l < r:
            mid = (l + r) / 2
            if count(mid) >= k:
                r = mid
            else:
                l = mid + 1e-9
        p = 0
        for i in range(n-1):
            j = n - 1
            while j > i and arr[i] > l * arr[j]:
                j -= 1
            if j > i and (p == 0 or arr[i] * arr[p[1]] > arr[p[0]] * arr[j]):
                p = (i, j)
        return [arr[p[0]], arr[p[1]]]