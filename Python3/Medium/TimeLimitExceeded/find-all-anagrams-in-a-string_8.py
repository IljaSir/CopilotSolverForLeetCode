class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if len(s) < len(p):
            return []
        res = []
        p_set = set(p)
        p_dict = {}
        for c in p:
            if c in p_dict:
                p_dict[c] += 1
            else:
                p_dict[c] = 1
        for i in range(len(s) - len(p) + 1):
            if s[i] in p_set:
                temp = p_dict.copy()
                for j in range(i, i + len(p)):
                    if s[j] in temp:
                        temp[s[j]] -= 1
                        if temp[s[j]] < 0:
                            break
                    else:
                        break
                else:
                    res.append(i)
        return res