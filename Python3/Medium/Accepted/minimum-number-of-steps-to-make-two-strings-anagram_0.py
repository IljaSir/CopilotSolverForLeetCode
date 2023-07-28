class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        s_dict = {}
        t_dict = {}
        for i in s:
            if i not in s_dict:
                s_dict[i] = 1
            else:
                s_dict[i] += 1
        for i in t:
            if i not in t_dict:
                t_dict[i] = 1
            else:
                t_dict[i] += 1
        count = 0
        for key in s_dict:
            if key not in t_dict:
                count += s_dict[key]
            elif s_dict[key] > t_dict[key]:
                count += s_dict[key] - t_dict[key]
        return count