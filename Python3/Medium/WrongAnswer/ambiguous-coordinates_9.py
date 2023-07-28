class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def get_nums(s):
            if s.startswith('0') and s.endswith('0'):
                return [s]
            if s.startswith('0'):
                return [s[0] + '.' + s[1:]]
            if s.endswith('0'):
                return [s]
            return [s] + [s[:i] + '.' + s[i:] for i in range(1, len(s))]
        s = s[1:-1]
        return ['({}, {})'.format(*t) for i in range(1, len(s)) for t in itertools.product(get_nums(s[:i]), get_nums(s[i:]))]