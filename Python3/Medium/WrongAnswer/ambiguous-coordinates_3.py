class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def f(s):
            n = len(s)
            if n == 1 or s[0] != '0' and s[-1] != '0':
                yield s
            for i in range(1, n):
                if (s[0] != '0' or i == 1) and s[i] != '0':
                    yield s[:i] + '.' + s[i:]
        s = s[1:-1]
        return ['({}, {})'.format(*cand) for i in range(1, len(s)) for cand in itertools.product(f(s[:i]), f(s[i:]))]