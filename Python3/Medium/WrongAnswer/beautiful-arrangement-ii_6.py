class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        res = [i for i in range(1, n - k)]
        for i in range(k + 1):
            res.append(res[-1] + (-1)**i * (k - i + 1))
        return res