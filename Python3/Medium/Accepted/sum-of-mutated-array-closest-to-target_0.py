class Solution:
    def findBestValue(self, arr: List[int], target: int) -> int:
        
        arr.sort()
        n = len(arr)
        p = [0]
        for i in arr:
            p.append(p[-1] + i)
        def check(x):
            i = bisect.bisect_left(arr, x)
            return p[i] + (n - i) * x
        l, r = 0, arr[-1]
        while l < r:
            mid = (l + r) >> 1
            if check(mid) >= target:
                r = mid
            else:
                l = mid + 1
        if abs(check(l) - target) >= abs(check(l - 1) - target):
            return l - 1
        return l