class Solution:
    def countDigits(self, num: int) -> int:
        
        num_str = str(num)
        count = 0
        for digit in num_str:
            if int(digit) != 0 and num % int(digit) == 0:
                count += 1
        return count