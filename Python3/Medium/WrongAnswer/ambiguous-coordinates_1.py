class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def parse(s):
            if len(s) == 1 or s[0] != '0' and s[-1] != '0':
                yield s
            elif s[0] == '0' and s[-1] == '0':
                pass
            elif s[0] == '0':
                yield '0.' + s[1:]
            else:
                for i in range(1, len(s)):
                    yield s[:i] + '.' + s[i:]
        s = s[1:-1]
        for i in range(1, len(s)):
            for x in parse(s[:i]):
                for y in parse(s[i:]):
                    yield '(' + x + ', ' + y + ')'