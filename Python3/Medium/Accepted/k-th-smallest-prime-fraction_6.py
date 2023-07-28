class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        n = len(arr)
        lo, hi = 0, 1
        while lo < hi:
            mid = (lo + hi) / 2
            count, best = 0, 0
            j = 1
            for i in range(n-1):
                while j < n and arr[i] > mid * arr[j]:
                    j += 1
                count += n - j
                if j < n and best < arr[i] / arr[j]:
                    best = arr[i] / arr[j]
                    p, q = i, j
            if count == k:
                return [arr[p], arr[q]]
            elif count < k:
                lo = mid
            else:
                hi = mid
        return []