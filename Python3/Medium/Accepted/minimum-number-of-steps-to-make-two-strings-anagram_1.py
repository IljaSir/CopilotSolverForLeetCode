class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        s_map = {}
        for c in s:
            if c not in s_map:
                s_map[c] = 1
            else:
                s_map[c] += 1
        t_map = {}
        for c in t:
            if c not in t_map:
                t_map[c] = 1
            else:
                t_map[c] += 1
        count = 0
        for c in s_map:
            if c not in t_map:
                count += s_map[c]
            elif s_map[c] > t_map[c]:
                count += s_map[c] - t_map[c]
        return count