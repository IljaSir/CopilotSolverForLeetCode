class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        
        def dfs(num, target, path, value, prev):
            if not num and value == target:
                res.append(path)
                return
            for i in range(1, len(num)+1):
                curr = num[:i]
                if len(curr) > 1 and curr[0] == '0':
                    return
                curr = int(curr)
                rest = num[i:]
                if not path:
                    dfs(rest, target, curr, curr, curr)
                else:
                    dfs(rest, target, path + '+' + str(curr), value + curr, curr)
                    dfs(rest, target, path + '-' + str(curr), value - curr, -curr)
                    dfs(rest, target, path + '*' + str(curr), value - prev + prev * curr, prev * curr)
        
        res = []
        dfs(num, target, '', 0, 0)
        return res