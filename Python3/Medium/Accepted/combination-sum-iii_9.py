class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def backtrack(start, k, n, tmp, res):
            if k == 0 and n == 0:
                res.append(tmp[:])
                return
            if n < 0 or k < 0:
                return
            for i in range(start, 10):
                tmp.append(i)
                backtrack(i + 1, k - 1, n - i, tmp, res)
                tmp.pop()
        res = []
        backtrack(1, k, n, [], res)
        return res