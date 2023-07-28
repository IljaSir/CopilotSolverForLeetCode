class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        # 1st solution: binary search
        # O(logn), O(1)
        left, right = 0, num
        while left <= right:
            mid = left + (right - left) // 2
            if mid * mid == num:
                return True
            elif mid * mid > num:
                right = mid - 1
            else:
                left = mid + 1
        return False

        # 2nd solution: newton method
        # O(logn), O(1)
        # x = num
        # while x * x > num:
        #     x = (x + num // x) // 2
        # return x * x == num

        # 3rd solution: brute force
        # O(sqrt(n)), O(1)
        # for i in range(num + 1):
        #     if i * i == num:
        #         return True
        # return False

        # 4th solution: math
        # O(sqrt(n)), O(1)
        # if num < 2:
        #     return True
        # x = num // 2
        # while x * x > num:
        #     x = (x + num // x) // 2
        # return x * x == num