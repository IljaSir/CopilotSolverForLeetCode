class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        
        # 1 <= m <= 5
        # 1 <= n <= 1000
        # 3^m = 27
        # 3^5 = 243
        # 3^1000 = 1.0623e+300
        # 10^9 + 7 = 1.000000007e+9
        # 1.0623e+300 < 1