class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        
        # 1. If palindrome has even length, replace the last char with 'a' if it is not 'a'
        # 2. If palindrome has odd length, replace the middle char with 'a' if it is not 'a'
        # 3. If palindrome has only 1 char or all chars are 'a', return empty string
        # 4. If palindrome has even length and all chars are 'a', replace the last char with 'b'
        # 5. If palindrome has odd length and all chars are 'a', replace the middle char with 'b'
        # 6. If palindrome has odd length and all chars are 'b' and the middle char is 'b', replace the last char with 'c'
        # 7. If palindrome has even length and all chars are 'b' and the last char is 'b', replace the last char with 'c'
        # 8. If palindrome has odd length and all chars are 'c' and the middle char is 'c', replace the last char with 'd'
        # 9. If palindrome has even length and all chars are 'c' and the last char is 'c', replace the last char with 'd'
        # 10. If palindrome has odd length and all chars are 'd' and the middle char is 'd', replace the last char with 'e'
        # 11. If palindrome has even length and all chars are 'd' and the last char is 'd', replace the last char with 'e'
        # 12. If palindrome has odd length and all chars are 'e' and the middle char is 'e', replace the last char with 'f'
        # 13. If palindrome has even length and all chars are 'e' and the last char is 'e', replace the last char with 'f'
        # 14. If palindrome has odd length and all chars are 'f' and the middle char is 'f', replace the last char with 'g'
        # 15. If palindrome has even length and all chars are 'f' and the last char is 'f', replace the last char with 'g'
        # 16. If palindrome has odd length and all chars are 'g' and the middle char is 'g', replace the last char with 'h'
        # 17. If palindrome has even length and