class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        s = list(s)
        max_length = 0
        while s:
            tmp = []
            for i in s:
                if i not in tmp:
                    tmp.append(i)
                else:
                    break
            max_length = max(max_length, len(tmp))
            s = s[1:]
        return max_length