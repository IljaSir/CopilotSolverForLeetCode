class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        
        # Solution 1: O(n) time, O(1) space
        # for i in range(1, arr[-1]):
        #     if i not in arr:
        #         k -= 1
        #     if k == 0:
        #         return i
        # return arr[-1] + k

        # Solution 2: O(logn) time, O(1) space
        left = 0
        right = len(arr)
        while left < right:
            mid = (left + right) // 2
            if arr[mid] - mid - 1 < k:
                left = mid + 1
            else:
                right = mid
        return left + k