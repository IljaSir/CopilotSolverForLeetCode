class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        
        def countLessThan(arr, num):
            count = 0
            for i in range(len(arr)):
                j = bisect.bisect_right(arr, num * arr[i])
                count += j - i - 1
            return count
        
        left, right = 0.0, 1.0
        while left < right:
            mid = (left + right) / 2
            if countLessThan(arr, mid) < k:
                left = mid
            else:
                right = mid
            if left + 1e-9 >= right:
                break
        count = countLessThan(arr, left)
        for i in range(len(arr)):
            j = bisect.bisect_right(arr, left * arr[i])
            count += j - i - 1
            if count == k:
                return [arr[i], arr[j - 1]]