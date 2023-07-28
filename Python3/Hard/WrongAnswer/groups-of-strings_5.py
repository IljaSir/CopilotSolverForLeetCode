class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        if not words:
            return []
        def is_connected(s1, s2):
            if len(s1) != len(s2):
                return False
            if s1 == s2:
                return True
            else:
                d = ord(s1[0]) - ord(s2[0])
                for i in range(1, len(s1)):
                    if ord(s1[i]) - ord(s2[i]) != d:
                        return False
                return True
        groups = []
        for w in words:
            for g in groups:
                if is_connected(w, g[0]):
                    g.append(w)
                    break
            else:
                groups.append([w])
        return [len(groups), max([len(g) for g in groups])]