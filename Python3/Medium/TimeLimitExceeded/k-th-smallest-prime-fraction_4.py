class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        n = len(arr)
        l, r = 0, 1
        while l < r:
            mid = (l + r) / 2
            cnt = 0
            j = 1
            for i in range(n):
                while j < n and arr[i] > mid * arr[j]:
                    j += 1
                cnt += n - j
            if cnt < k:
                l = mid
            else:
                r = mid
        return [arr[i], arr[j]] if cnt == k else [arr[i], arr[j - 1]]