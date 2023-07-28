class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        
        if n == 0:
            return 1
        ans = 10
        uniqueDigits = 9
        availableNumber = 9
        while n > 1 and availableNumber > 0:
            uniqueDigits = uniqueDigits * availableNumber
            ans += uniqueDigits
            availableNumber -= 1
            n -= 1
        return ans