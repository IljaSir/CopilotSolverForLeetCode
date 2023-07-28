class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        s = s[1:-1]
        def possible(s):
            if not s or (s[0] == '0' and s[-1] == '0'): return []
            if s[0] == '0': return [s[0] + '.' + s[1:]]
            if s[-1] == '0': return [s]
            return [s] + [s[:i] + '.' + s[i:] for i in range(1, len(s))]
        return ['({}, {})'.format(a, b) for i in range(1, len(s)) for a in possible(s[:i]) for b in possible(s[i:])]