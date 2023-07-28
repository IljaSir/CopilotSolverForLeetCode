class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def f(s):
            if len(s) == 1 or s[-1] != "0" and s[0] != "0":
                yield s
            if s[0] != "0" and s[-1] == "0":
                yield s[:-1]
            if s[0] == "0" and s[-1] != "0":
                yield "0." + s[1:]
        s = s[1:-1]
        return ["({}, {})".format(a, b) for i in range(1, len(s)) for a in f(s[:i]) for b in f(s[i:])]