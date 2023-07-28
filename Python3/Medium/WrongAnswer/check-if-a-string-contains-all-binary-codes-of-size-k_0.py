class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        
        if len(s) < k:
            return False
        if len(s) == k:
            return True
        if k == 1:
            return True
        if k == 2:
            return "00" in s and "01" in s and "10" in s and "11" in s
        if k == 3:
            return "000" in s and "001" in s and "010" in s and "011" in s and "100" in s and "101" in s and "110" in s and "111" in s
        if k == 4:
            return "0000" in s and "0001" in s and "0010" in s and "0011" in s and "0100" in s and "0101" in s and "0110" in s and "0111" in s and "1000" in s and "1001" in s and "1010" in s and "1011" in s and "1100" in s and "1101" in s and "1110" in s and "1111" in s
        if k == 5:
            return "00000" in s and "00001" in s and "00010" in s and "00011" in s and "00100" in s and "00101" in s and "00110" in s and "00111" in s and "01000" in s and "01001" in s and "01010" in s and "01011" in s and "01100" in s and "01101" in s and "01110" in s and "01111" in s and "10000" in s and "10001" in s and "10010" in s and "10011" in s and "10100" in s and "10101" in s and "10110" in s and "10111" in s and "11000" in s and "11001" in s and "11010" in s and "11011" in s and "11100" in s and "11101" in s and "11110" in s and "11111" in s