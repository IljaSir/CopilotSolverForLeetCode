class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        # # 1st solution: binary search
        # # O(log n), O(1)
        # if num == 1:
        #     return True
        # left, right = 0, num // 2
        # while left <= right:
        #     mid = (left + right) // 2
        #     if mid * mid == num:
        #         return True
        #     elif mid * mid < num:
        #         left = mid + 1
        #     else:
        #         right = mid - 1
        # return False

        # 2nd solution: Newton's method
        # O(log n), O(1)
        if num == 1:
            return True
        x = num // 2
        while x * x > num:
            x = (x + num // x) // 2
        return x * x == num