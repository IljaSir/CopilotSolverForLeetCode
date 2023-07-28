class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def count(x):
            count, j = 0, 1
            for i in range(len(arr) - 1):
                while j < len(arr) and arr[i] > x * arr[j]:
                    j += 1
                count += len(arr) - j
            return count
        l, r = 0, 1
        while l < r:
            mid = (l + r) / 2
            if count(mid) >= k:
                r = mid
            else:
                l = mid + 1e-9
        p = 0
        for i in range(len(arr) - 1):
            j = bisect.bisect_right(arr, l * arr[i])
            p += j
            if p >= k:
                return [arr[i], arr[j - (p - k) - 1]]