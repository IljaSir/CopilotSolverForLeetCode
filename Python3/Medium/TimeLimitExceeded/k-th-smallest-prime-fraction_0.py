class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def count(x):
            res, j = 0, 0
            for i in range(len(arr)):
                while j < len(arr) and arr[i] > x * arr[j]:
                    j += 1
                res += len(arr) - j
            return res
        lo, hi = 0, 1
        while lo < hi:
            mid = (lo + hi) / 2
            if count(mid) < k:
                lo = mid
            else:
                hi = mid
        p = q = 0
        for i in range(len(arr)):
            j = bisect.bisect_left(arr, lo * arr[i])
            if j < len(arr) and arr[i] > lo * arr[j] and (p == 0 or arr[i] * q < p * arr[j]):
                p, q = arr[i], arr[j]
        return [p, q]