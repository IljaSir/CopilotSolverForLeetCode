class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        
        def dfs(prefix, last_digit):
            if prefix > high:
                return []
            if prefix >= low:
                res.append(prefix)
            if last_digit < 9:
                dfs(prefix * 10 + last_digit + 1, last_digit + 1)
        res = []
        for i in range(1, 10):
            dfs(i, i)
        return res