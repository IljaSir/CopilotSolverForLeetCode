class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        
        i, d = 0, len(s)
        result = []
        for c in s:
            if c == 'I':
                result.append(i)
                i += 1
            else:
                result.append(d)
                d -= 1
        result.append(i)
        return result