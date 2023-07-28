class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        
        if num == 1:
            return False
        i, sum = 2, 1
        while i * i < num:
            if num % i == 0:
                sum += i + num // i
            i += 1
        if i * i == num:
            sum += i
        return sum == num