class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        a = list(range(1, n-k))
        for i in range(k+1):
            if i % 2 == 0:
                a.append(n-k + i//2)
            else:
                a.append(n - i//2)
        return a