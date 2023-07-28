class Solution:
    def getLucky(self, s: str, k: int) -> int:
        
        def convert_to_digit(s):
            return [ord(c)-96 for c in s]
        def convert_to_sum_of_digits(s):
            return sum([int(c) for c in str(s)])
        digits = convert_to_digit(s)
        digits = ''.join([str(d) for d in digits])
        for _ in range(k):
            digits = convert_to_sum_of_digits(digits)
        return digits