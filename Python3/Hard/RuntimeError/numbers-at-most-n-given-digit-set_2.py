class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        
        
        def count_digits(n):
            count = 0
            while n:
                n //= 10
                count += 1
            return count
        
        def count_numbers_with_n_digits(n):
            return len(digits) ** n
        
        def count_numbers_with_less_digits(n):
            count = 0
            for digit in digits:
                if int(digit) < n:
                    count += 1
            return count
        
        def count_numbers_with_same_digits(n, digits):
            count = 0
            for digit in digits:
                if int(digit) == n:
                    count += 1
            return count
        
        def count_numbers_with_less_digits2(n, digits):
            count = 0
            for digit in digits:
                if int(digit) < n:
                    count += 1
            return count
        
        def count_numbers_with_less_digits3(n, digits):
            count = 0
            for digit in digits:
                if int(digit) <= n:
                    count += 1
            return count
        
        def count_numbers_with_same_digits2(n, digits):
            count = 0
            for digit in digits:
                if int(digit) == n:
                    count += 1
            return count
        
        def count_numbers_with_less_digits4(n, digits):
            count = 0
            for digit in digits:
                if int(digit) < n:
                    count += 1
            return count
        
        def count_numbers_with_same_digits3(n, digits):
            count = 0
            for digit in digits:
                if int(digit) == n:
                    count += 1
            return count
        
        def count_numbers_with_less_digits5(n, digits):
            count = 0
            for digit in digits:
                if int(digit) < n:
                    count += 1
            return count
        
        def count_numbers_with_same_digits4(n, digits):
            count = 0
            for digit in digits:
                if int(digit) == n:
                    count += 1
            return count
        
        def count_numbers_with_less_digits6(n, digits):
            count = 0
            for digit in digits:
                if int(digit) < n:
                    count += 1
            return count
        
        def count_numbers_with_same_digits5(n, digits):
            count = 0
            for digit in digits