class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        def possible_num(s):
            if len(s) == 1:
                return True
            if s[0] == '0' and s[-1] == '0':
                return False
            if s[0] == '0' or s[-1] == '0':
                return True
            return True
        s = s[1:-1]
        ans = []
        for i in range(1, len(s)):
            for x in itertools.product(*map(possible_num, [s[:i], s[i:]])):
                if all(x):
                    ans.append('({}, {})'.format(s[:i], s[i:]))
                elif x[0] and s[i] != '0':
                    ans.append('({}.{}, {})'.format(s[:i], s[i], s[i+1:]))
                elif x[1] and s[i-1] != '0':
                    ans.append('({}, {}.{})'.format(s[:i-1], s[i-1], s[i:]))
        return ans