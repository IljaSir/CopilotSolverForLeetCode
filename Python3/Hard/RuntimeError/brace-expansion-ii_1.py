class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        
        
        def parse(s):
            if len(s) == 1 and s[0].isalpha():
                return [s]
            if s[0] == '{':
                stack = []
                for i, c in enumerate(s):
                    if c == '{':
                        stack.append(i)
                    elif c == '}':
                        start = stack.pop()
                        if not stack:
                            break
                return parse(s[1:start]) + parse(s[start+2:-1])
            res = []
            for i, c in enumerate(s):
                if c == '{':
                    stack = []
                    for j, cc in enumerate(s[i:]):
                        if cc == '{':
                            stack.append(j)
                        elif cc == '}':
                            start = stack.pop()
                            if not stack:
                                break
                    res.append(parse(s[i+1:i+start]) + parse(s[i+start+2:i+j]))
                    i += j
                elif c == ',':
                    res.append(parse(s[:i]) + parse(s[i+1:]))
                    break
            return res
        
        def get_res(s):
            if isinstance(s, list):
                res = []
                for ss in s:
                    res += get_res(ss)
                return res
            return [s]
        
        return sorted(set(get_res(parse(expression))))