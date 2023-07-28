class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        
        # # 1st attempt: 32ms 94.22%
        # # O(n)
        # i = 0
        # j = 1
        # while i < len(arr):
        #     if arr[i] != j:
        #         k -= 1
        #         if k == 0:
        #             return j
        #     else:
        #         i += 1
        #     j += 1
        # return arr[-1] + k
        
        # 2nd attempt: 28ms 99.85%
        # O(logn)
        # Binary search
        left, right = 0, len(arr) - 1
        while left <= right:
            mid = (left + right) // 2
            if arr[mid] - mid - 1 < k:
                left = mid + 1
            else:
                right = mid - 1
        return left + k