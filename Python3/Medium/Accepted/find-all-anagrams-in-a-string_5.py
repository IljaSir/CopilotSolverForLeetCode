class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        res = []
        p_dict = dict()
        s_dict = dict()
        for i in p:
            if i in p_dict:
                p_dict[i] += 1
            else:
                p_dict[i] = 1
        for i in range(len(s)):
            if s[i] in s_dict:
                s_dict[s[i]] += 1
            else:
                s_dict[s[i]] = 1
            if i >= len(p):
                if s_dict[s[i-len(p)]] == 1:
                    s_dict.pop(s[i-len(p)])
                else:
                    s_dict[s[i-len(p)]] -= 1
            if s_dict == p_dict:
                res.append(i-len(p)+1)
        return res