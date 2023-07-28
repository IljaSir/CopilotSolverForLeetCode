class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        ans = list(range(1, n - k))
        for i in range(k + 1):
            ans.append(n - k + i // 2 if i % 2 == 0 else n - i // 2)
        return ans