class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        out = ""
        for i in range(len(indices)):
            if s[indices[i]:indices[i]+len(sources[i])] == sources[i]:
                s = s[:indices[i]] + targets[i] + s[indices[i]+len(sources[i]):]
                for j in range(i+1, len(indices)):
                    indices[j] += len(targets[i]) - len(sources[i])
        return s