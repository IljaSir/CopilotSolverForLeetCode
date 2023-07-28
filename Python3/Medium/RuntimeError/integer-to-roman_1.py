class Solution:
    def intToRoman(self, num: int) -> str:
        
        # I can be placed before V (5) and X (10) to make 4 and 9.
        # X can be placed before L (50) and C (100) to make 40 and 90.
        # C can be placed before D (500) and M (1000) to make 400 and 900.
        # M = 1000, CM = 900, XC = 90 and IV = 4.
        # L = 50, V = 5, III = 3.
        # MCMXCIV