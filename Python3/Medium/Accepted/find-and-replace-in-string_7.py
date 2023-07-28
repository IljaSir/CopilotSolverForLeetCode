class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        s = list(s)
        for i, source, target in sorted(zip(indices, sources, targets), reverse=True):
            if all(i + j < len(s) and s[i + j] == c for j, c in enumerate(source)):
                s[i:i + len(source)] = target
        return "".join(s)