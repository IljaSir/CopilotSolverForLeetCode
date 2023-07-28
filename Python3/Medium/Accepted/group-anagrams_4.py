class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        from collections import defaultdict
        d = defaultdict(list)
        for s in strs:
            d[tuple(sorted(s))].append(s)
        return list(d.values())