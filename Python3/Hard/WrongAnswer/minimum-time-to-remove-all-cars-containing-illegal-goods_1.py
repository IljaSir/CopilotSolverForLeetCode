class Solution:
    def minimumTime(self, s: str) -> int:
        
        n = len(s)
        if n == 1:
            return 1
        if n == 2:
            return 2
        left = 0
        right = n - 1
        while s[left] == '0' and left < n:
            left += 1
        while s[right] == '0' and right >= 0:
            right -= 1
        if left == n:
            return 0
        if left == right:
            return 1
        return 2 + min(2 * (left + 1), 2 * (n - right))