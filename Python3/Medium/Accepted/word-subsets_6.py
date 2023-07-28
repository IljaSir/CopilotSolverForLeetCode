class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        def get_map(word):
            m = {}
            for c in word:
                m[c] = m.get(c, 0) + 1
            return m
        m2 = {}
        for word in words2:
            m = get_map(word)
            for k, v in m.items():
                m2[k] = max(m2.get(k, 0), v)
        res = []
        for word in words1:
            m = get_map(word)
            for k, v in m2.items():
                if k not in m or m[k] < v:
                    break
            else:
                res.append(word)
        return res