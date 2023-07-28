class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def dfs(i, pre, cur, res):
            if i == len(num):
                return len(res) >= 3
            cur = cur * 10 + int(num[i])
            if cur > 2 ** 31 - 1:
                return False
            if pre + cur == res[-1]:
                res.append(cur)
                if dfs(i + 1, cur, 0, res):
                    return True
                res.pop()
            elif len(res) < 2 or pre + cur < res[-1]:
                if dfs(i + 1, pre, cur, res):
                    return True
            return False
        return dfs(0, 0, 0, []) and [int(i) for i in num.split('0')]