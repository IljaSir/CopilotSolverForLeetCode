class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        
        length = len(password)
        if length < 8:
            return False
        lower = False
        upper = False
        digit = False
        special = False
        for char in password:
            if char.islower():
                lower = True
            elif char.isupper():
                upper = True
            elif char.isdigit():
                digit = True
            elif char in "!@#$%^&*()-+":
                special = True
        return lower and upper and digit and special