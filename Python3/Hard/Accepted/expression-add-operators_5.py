class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(num, target, prev, cur, value, expr):
            if not num and value == target:
                res.append(expr)
                return
            for i in range(1, len(num) + 1):
                cur = num[:i]
                if len(cur) > 1 and cur[0] == '0':
                    return
                nxt = num[i:]
                if expr:
                    dfs(nxt, target, int(cur), int(cur), value + int(cur), expr + '+' + cur)
                    dfs(nxt, target, -int(cur), -int(cur), value - int(cur), expr + '-' + cur)
                    dfs(nxt, target, prev * int(cur), prev * int(cur), value - prev + prev * int(cur), expr + '*' + cur)
                else:
                    dfs(nxt, target, int(cur), int(cur), int(cur), cur)
        res = []
        dfs(num, target, 0, 0, 0, '')
        return res