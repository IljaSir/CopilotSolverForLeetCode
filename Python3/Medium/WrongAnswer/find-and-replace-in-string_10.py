class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        s = list(s)
        for i, index in enumerate(indices):
            if s[index:index+len(sources[i])] == list(sources[i]):
                s[index:index+len(sources[i])] = list(targets[i])
        return ''.join(s)