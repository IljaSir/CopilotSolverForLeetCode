class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        for i in reversed(range(len(indices))):
            if s[indices[i]:indices[i]+len(sources[i])] == sources[i]:
                s = s[:indices[i]] + targets[i] + s[indices[i]+len(sources[i]):]
        return s