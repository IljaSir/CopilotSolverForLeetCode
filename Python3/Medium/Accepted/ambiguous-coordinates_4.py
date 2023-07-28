class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def f(s):
            if not s or (len(s) > 1 and s[0] == '0' and s[-1] == '0'):
                return []
            if s[-1] == '0':
                return [s]
            if s[0] == '0':
                return [s[0] + '.' + s[1:]]
            return [s] + [s[:i] + '.' + s[i:] for i in range(1, len(s))]
        s = s[1:-1]
        return ['({}, {})'.format(*t) for i in range(1, len(s)) for t in itertools.product(f(s[:i]), f(s[i:]))]