class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        zero_count = 0
        one_count = 0
        max_zero = 0
        max_one = 0
        for i in s:
            if i == "0":
                zero_count += 1
                if zero_count > max_zero:
                    max_zero = zero_count
                one_count = 0
            else:
                one_count += 1
                if one_count > max_one:
                    max_one = one_count
                zero_count = 0
        return max_one > max_zero