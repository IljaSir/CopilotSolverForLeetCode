class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(num, target, path, value, last):
            if not num and value == target:
                res.append(path)
                return
            for i in range(1, len(num) + 1):
                curr = num[:i]
                if len(curr) > 1 and curr[0] == '0':
                    return
                next = num[i:]
                if path:
                    dfs(next, target, path + '+' + curr, value + int(curr), int(curr))
                    dfs(next, target, path + '-' + curr, value - int(curr), -int(curr))
                    dfs(next, target, path + '*' + curr, value - last + last * int(curr), last * int(curr))
                else:
                    dfs(next, target, curr, int(curr), int(curr))
        res = []
        dfs(num, target, '', 0, 0)
        return res