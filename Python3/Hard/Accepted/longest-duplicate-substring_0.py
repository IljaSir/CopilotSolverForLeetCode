class Solution:
    def longestDupSubstring(self, s: str) -> str:
        
        
        def check(dup):
            seen = set()
            for i in range(len(s) - dup + 1):
                if s[i:i+dup] in seen:
                    return i
                seen.add(s[i:i+dup])
            return -1
        
        l, r = 0, len(s)
        while l < r:
            mid = (l + r + 1) // 2
            if check(mid) != -1:
                l = mid
            else:
                r = mid - 1
        idx = check(l)
        return s[idx:idx+l] if idx != -1 else ""