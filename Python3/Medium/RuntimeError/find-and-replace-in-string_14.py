class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        # sort indices by index
        indices = sorted([(i, s, t) for i, s, t in zip(indices, sources, targets)], key=lambda x: x[0])
        # find the index of the first source
        i = 0
        while i < len(indices) and indices[i][0] >= len(s):
            i += 1
        # if there is no source, return s
        if i == len(indices):
            return s
        # start with the first source
        res = s[:indices[i][0]]
        # for each source
        for j in range(i, len(indices)):
            # find the index of the next source
            k = j + 1
            while k < len(indices) and indices[k][0] >= len(s):
                k += 1
            # if there is no next source
            if k == len(indices):
                # find the index of the next character
                l = len(s)
            # if there is a next source
            else:
                # find the index of the next character
                l = indices[k][0]
            # if the next character is in the source
            if indices[j][0] + len(indices[j][1]) <= l:
                # if the source is in the string
                if s[indices[j][0]:indices[j][0] + len(indices[j][1])] == indices[j][1]:
                    # replace the source with the target
                    res += indices[][2]
                # if the source is not in the string
                else:
                    # d not replace the source
                    res += s[dices[j][0]:indices[j][0] + lenindices[j][1])]
            # if the next character is not in the souce
            le:
                # do not replace the source
                res += s[indices[j][0]:indices[j][0] + len(indices[j][1]]
        # return the result
        return res

def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        n = len(s)
        m = len(indices)
        res = []
        i = 0
        j = 0
        while i < n:
            if j < m and i == indices[j]:
                if s[i:i+len(sources[j])] == sources[j]:
                    res.append(targets[j])
                    i += len(sources[j])
                else:
                    res.append(s[i])
                    i += 1
                j += 1
            else:
                res.append(s[i])
                i += 1
        return ''.join(res)