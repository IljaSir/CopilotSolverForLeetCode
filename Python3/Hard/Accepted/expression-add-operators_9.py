class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        
        def dfs(num, target, val, prev, cur, res):
            if not num and val == target:
                res.append(cur)
                return
            for i in range(1, len(num)+1):
                curr = num[:i]
                if curr[0] == '0' and len(curr) > 1:
                    continue
                if not cur:
                    dfs(num[i:], target, int(curr), int(curr), curr, res)
                else:
                    dfs(num[i:], target, val+int(curr), int(curr), cur+'+'+curr, res)
                    dfs(num[i:], target, val-int(curr), -int(curr), cur+'-'+curr, res)
                    dfs(num[i:], target, val-prev+prev*int(curr), prev*int(curr), cur+'*'+curr, res)
        res = []
        dfs(num, target, 0, 0, '', res)
        return res