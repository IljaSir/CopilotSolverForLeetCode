class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        d = {}
        for s in strs:
            k = tuple(sorted(s))
            if k in d:
                d[k].append(s)
            else:
                d[k] = [s]
        return list(d.values())