class Solution:
    def sumBase(self, n: int, k: int) -> int:
        
        # convert n to base k
        # sum digits
        # return sum
        # n = 34
        # k = 6
        # 34 % 6 = 4
        # 34 // 6 = 5
        # 5 % 6 = 5
        # 5 // 6 = 0
        # 5 * 10 + 4 = 54
        # 54 % 10 = 4
        # 54 // 10 = 5
        # 5 % 10 = 5
        # 5 // 10 = 0
        # 5 + 4 = 9
        base_k = 0
        while n > 0:
            base_k = base_k * k + (n % k)
            n = n // k
        # print(base_k)
        sum_digits = 0
        while base_k > 0:
            sum_digits = sum_digits * 10 + (base_k % 10)
            base_k = base_k // 10
        # print(sum_digits)
        sum_base_k = 0
        while sum_digits > 0:
            sum_base_k += sum_digits % 10
            sum_digits = sum_digits // 10
        return sum_base_k