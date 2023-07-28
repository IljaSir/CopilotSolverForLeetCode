class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def gen(left, right, path, res):
            if right < left:
                return
            if left == 0 and right == 0:
                res.append(path)
                return
            if left > 0:
                gen(left-1, right, path+'(', res)
            if right > 0:
                gen(left, right-1, path+')', res)
        res = []
        gen(n, n, '', res)
        return res