class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def count_less_than(arr, val):
            count = 0
            for i in range(len(arr)):
                j = bisect.bisect_right(arr, val * arr[i])
                count += j - i - 1
            return count
        
        lo, hi = 0, 1
        while lo < hi:
            mid = (lo + hi) / 2
            if count_less_than(arr, mid) >= k:
                hi = mid
            else:
                lo = mid + 1e-9
        p = 0
        for i in range(len(arr)):
            j = bisect.bisect_right(arr, lo * arr[i])
            p += j - i - 1
            if p >= k:
                return [arr[i], arr[j - 1]]
            i = j