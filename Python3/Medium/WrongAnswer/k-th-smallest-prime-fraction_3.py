class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        n = len(arr)
        lo = 0
        hi = 1
        while lo < hi:
            mid = (lo + hi) / 2
            count = 0
            p = 0
            q = 1
            for i in range(n):
                j = bisect.bisect(arr, mid * arr[i])
                count += n - j
                if j < n and p * arr[j] < q * arr[i]:
                    p = arr[i]
                    q = arr[j]
            if count < k:
                lo = mid
            else:
                hi = mid
        return [p, q]