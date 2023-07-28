class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        # get the number of digits
        digit = 0
        num = n
        while num > 0:
            num //= 10
            digit += 1
        # get the first digit
        first_digit = n // 10 ** (digit - 1)
        # get the number of 1s in the first digit
        if first_digit > 1:
            num_first_digit = 10 ** (digit - 1)
        elif first_digit == 1:
            num_first_digit = n % (10 ** (digit - 1)) + 1
        else:
            num_first_digit = 0
        # get the number of 1s in other digits
        num_other_digits = first_digit * (digit - 1) * (10 ** (digit - 2))
        return num_first_digit + num_other_digits + self.countDigitOne(n % (10 ** (digit - 1)))