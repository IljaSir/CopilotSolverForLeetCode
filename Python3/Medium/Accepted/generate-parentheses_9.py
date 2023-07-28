class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def helper(n, left, right, path, res):
            if left == n and right == n:
                res.append(path)
                return
            if left < n:
                helper(n, left+1, right, path + '(', res)
            if right < left:
                helper(n, left, right+1, path + ')', res)
        res = []
        helper(n, 0, 0, '', res)
        return res