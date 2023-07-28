class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        max_len = 0
        for i in range(len(s)):
            tmp = set()
            for j in range(i, len(s)):
                if s[j] not in tmp:
                    tmp.add(s[j])
                    max_len = max(max_len, len(tmp))
                else:
                    break
        return max_len