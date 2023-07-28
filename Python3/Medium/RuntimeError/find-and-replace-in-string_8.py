class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        out = ""
        for i in range(len(indices)):
            if s[indices[i]:indices[i]+len(sources[i])] == sources[i]:
                s = s[:indi