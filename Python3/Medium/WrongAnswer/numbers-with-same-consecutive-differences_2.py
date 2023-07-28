class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        if n == 1:
            return [i for i in range(10)]
        res = []
        for i in range(1, 10):
            q = [i]
            for j in range(n - 1):
                next_q = []
                for x in q:
                    if x % 10 - k >= 0:
                        next_q.append(x * 10 + x % 10 - k)
                    if x % 10 + k <= 9:
                        next_q.append(x * 10 + x % 10 + k)
                q = next_q
            res.extend(q)
        return res