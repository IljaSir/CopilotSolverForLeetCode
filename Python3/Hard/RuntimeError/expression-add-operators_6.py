class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(num, target, path, res, prev, cur):
            if not num and cur == target:
                res.append(path)
                return
            for i in range(1, len(num) + 1):
                curr = num[:i]
                if len(curr) > 1 and curr[0] == '0':
                    return
                curr = int(curr)
                if not path:
                    dfs(num[i:], target, curr, res, curr, curr)
                else:
                    dfs(num[i:], target, path + '+' + str(curr), res, curr, cur + curr)
                    dfs(num[i:], target, path + '-' + str(curr), res, -curr, cur - curr)
                    dfs(num[i:], target, path + '*' + str(curr), res, prev * curr, cur - prev + prev * curr)
        res = []
        dfs(num, target, '', res, 0, 0)
        return res