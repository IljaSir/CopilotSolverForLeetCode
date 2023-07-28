class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        indices = sorted(zip(indices, sources, targets), key=lambda x: x[0])
        res = ''
        i = 0
        while i < len(s):
            if indices and indices[0][0] == i:
                if s[i:].startswith(indices[0][1]):
                    res += indices[0][2]
                    i += len(indices[0][1])
                    indices.pop(0)
                else:
                    res += s[i]
                    i += 1
            else:
                res += s[i]
                i += 1
        return resces[i]] + targets[i] + s[indices[i]+len(sources[i]):]
                for j in range(i+1, len(indices)):
                    indices[j] += len(targets[i]) - len(sources[i])
        return s