class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        res = [1]
        for i in range(k):
            res.append(res[-1] + (-1)**i * (k - i))
        return res + list(range(k + 2, n + 1))