class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # print(s)
        if not s:
            return 0
        if len(s) == 1:
            return 1
        maxLen = 0
        for i in range(len(s)):
            for j in range(i+1, len(s)):
                if s[j] not in s[i:j]:
                    if j-i+1 > maxLen:
                        maxLen = j-i+1
                else:
                    break
        return maxLen