class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def check(target):
            count, i = 0, 0
            for j in range(1, n):
                while arr[i] < target * arr[j]:
                    i += 1
                count += i
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
        for i in range(1, n):
            if arr[p] < lo * arr[i]:
                p = i
        return [arr[p], int(lo * arr[p])]