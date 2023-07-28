class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(num, target, path, result, pos, value, prev):
            if pos == len(num):
                if target == value:
                    result.append(path)
                return
            for i in range(pos, len(num)):
                if i != pos and num[pos] == '0':
                    break
                cur = int(num[pos:i+1])
                if pos == 0:
                    dfs(num, target, path + str(cur), result, i + 1, cur, cur)
                else:
                    dfs(num, target, path + '+' + str(cur), result, i + 1, value + cur, cur)
                    dfs(num, target, path + '-' + str(cur), result, i + 1, value - cur, -cur)
                    dfs(num, target, path + '*' + str(cur), result, i + 1, value - prev + prev * cur, prev * cur)
        result = []
        dfs(num, target, '', result, 0, 0, 0)
        return result