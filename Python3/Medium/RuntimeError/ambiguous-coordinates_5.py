class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def f(s):
            n = len(s)
            if n == 1:
                return [s]
            if s[0] == '0' and s[-1] == '0':
                return []
            if s[0] == '0':
                return [s[0] + '.' + s[1:]]
            if s[-1] == '0':
                return [s]
            return [s] + [s[:i] + '.' + s[i:] for i in range(1, n)]
        s = s[1:-1]
        return ['({}, {})'.format(i, j) for i, j in itertools.product(f(s[:i]), f(s[i:])) for i in range(1, len(s))]