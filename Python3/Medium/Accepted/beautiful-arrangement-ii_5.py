class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        res = []
        for i in range(1, n-k):
            res.append(i)
        for i in range(k+1):
            if i % 2 == 0:
                res.append(n-k+i//2)
            else:
                res.append(n-i//2)
        return res