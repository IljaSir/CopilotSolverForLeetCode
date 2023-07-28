class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        
        if len(s) == 1:
            return 1
        if len(s) == 2:
            if ord(s[0]) == ord(s[1]) - 1:
                return 2
            else:
                return 1
        count = 1
        max_count = 1
        for i in range(len(s)-1):
            if ord(s[i]) == ord(s[i+1]) - 1:
                count += 1
            else:
                if count > max_count:
                    max_count = count
                count = 1
        return max_count