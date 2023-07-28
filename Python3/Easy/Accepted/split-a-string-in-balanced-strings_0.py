class Solution:
    def balancedStringSplit(self, s: str) -> int:
        
        count = 0
        num = 0
        for i in s:
            if i == 'L':
                num += 1
            else:
                num -= 1
            if num == 0:
                count += 1
        return count