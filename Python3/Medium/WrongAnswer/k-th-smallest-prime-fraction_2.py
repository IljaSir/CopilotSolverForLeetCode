class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def check(x):
            count = 0
            j = 1
            for i in range(n-1):
                while j < n and arr[i] > x * arr[j]:
                    j += 1
                count += n - j
            return count >= k
        n = len(arr)
        lo, hi = 0, 1
        while lo < hi:
            mid = (lo + hi) / 2
            if check(mid):
                hi = mid
            else:
                lo = mid + 1e-9
        p = 0
        for i in range(n-1):
            j = bisect.bisect_right(arr, lo * arr[i])
            p += j
            if p >= k:
                return [arr[i], arr[j - (p - k) - 1]]