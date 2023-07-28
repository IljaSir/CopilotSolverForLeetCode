class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        if len(s) == 1:
            return True
        s_to_t = {}
        t_to_s = {}
        for i in range(len(s)):
            s_c = s[i]
            t_c = t[i]
            if s_c in s_to_t:
                if s_to_t[s_c] != t_c:
                    return False
            else:
                s_to_t[s_c] = t_c
            if t_c in t_to_s:
                if t_to_s[t_c] != s_c:
                    return False
            else:
                t_to_s[t_c] = s_c
        return True