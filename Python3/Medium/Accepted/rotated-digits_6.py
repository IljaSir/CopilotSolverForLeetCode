class Solution:
    def rotatedDigits(self, n: int) -> int:
        
        valid = ['2', '5', '6', '9']
        invalid = ['3', '4', '7']
        count = 0
        for i in range(1, n + 1):
            s = str(i)
            if any(x in s for x in valid) and not any(x in s for x in invalid):
                count += 1
        return count