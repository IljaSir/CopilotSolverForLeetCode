class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        # 1st solution: brute force
        # O(m*n) time | O(1) space
        if not s or not t:
            return ""
        if len(s) < len(t):
            return ""
        if len(t) == 1:
            if t in s:
                return t
            else:
                return ""
        if len(t) == len(s):
            if t == s:
                return t
            else:
                return ""
        t_dict = {}
        for c in t:
            if c in t_dict:
                t_dict[c] += 1
            else:
                t_dict[c] = 1
        min_len = len(s) + 1
        min_str = ""
        for i in range(len(s)):
            for j in range(i, len(s)):
                s_dict = {}
                for c in s[i:j+1]:
                    if c in s_dict:
                        s_dict[c] += 1
                    else:
                        s_dict[c] = 1
                if self.is_substring(s_dict, t_dict):
                    if j - i + 1 < min_len:
                        min_len = j - i + 1
                        min_str = s[i:j+1]
        return min_str