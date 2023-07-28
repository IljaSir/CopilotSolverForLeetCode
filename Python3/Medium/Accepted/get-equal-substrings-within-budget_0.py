class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        
        n = len(s)
        cost = [abs(ord(s[i]) - ord(t[i])) for i in range(n)]
        left = 0
        right = 0
        res = 0
        cur = 0
        while right < n:
            cur += cost[right]
            while left < right and cur > maxCost:
                cur -= cost[left]
                left += 1
            if cur <= maxCost:
                res = max(res, right - left + 1)
            right += 1
        return res