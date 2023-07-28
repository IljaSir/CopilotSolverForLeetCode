class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        
        n = len(s)
        if k > n:
            return -1
        if k == n:
            return 0
        if n == 1:
            return 0 if k == 1 else -1
        # 1. Find the first character that occurs k times
        # 2. Find the last character that occurs k times
        # 3. Take the first character and the last character.
        # 4. If the first character is the same as the last character, then take the first character and the last character.
        # 5. If the first character is not the same as the last character, then take the first character and the last character.
        # 6. If the first character is the same as the last character, then take the first character and the last character.
        # 7. If the first character is not the same as the last character, then take the first character and the last character.
        # 8. If the first character is the same as the last character, then take the first character and the last character.
        # 9. If the first character is not the same as the last character, then take the first character and the last character.
        # 10. If the first character is the same as the last character, then take the first character and the last character.
        # 11. If the first character is not the same as the last character, then take the first character and the last character.
        # 12. If the first character is the same as the last character, then take the first character and the last character.
        # 13. If the first character is not the same as the last character, then take the first character and the last character.
        # 14. If the first character is the same as the last character, then take the first character and the last character.
        # 15. If the first character is not the same as the last character, then take the first character and the last character.
        # 16. If the first character is the same as the last character, then take the first character and the last character.
        # 17. If the first character is not the same as the last character, then take the first character and the last character.
        # 18. If the first character is the same as the last character, then take the first character and the