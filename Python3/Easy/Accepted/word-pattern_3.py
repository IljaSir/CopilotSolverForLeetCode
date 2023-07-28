class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        
        if len(pattern) != len(s.split()):
            return False
        pattern_dict = {}
        s_dict = {}
        for i in range(len(pattern)):
            if pattern[i] not in pattern_dict:
                pattern_dict[pattern[i]] = s.split()[i]
            else:
                if pattern_dict[pattern[i]] != s.split()[i]:
                    return False
            if s.split()[i] not in s_dict:
                s_dict[s.split()[i]] = pattern[i]
            else:
                if s_dict[s.split()[i]] != pattern[i]:
                    return False
        return True