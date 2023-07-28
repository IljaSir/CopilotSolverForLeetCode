class Solution:
    def countTriples(self, n: int) -> int:
        
        # 0 <= a <= n
        # 0 <= b <= n
        # 1 <= c <= n
        # a^2 + b^2 = c^2
        # 0 <= a^2 + b^2 <= n^2
        # 0 <= a^2 + b^2 <= n^2
        # 0 <= a^2 <= n^2
        # 0 <= b^2 <= n^2