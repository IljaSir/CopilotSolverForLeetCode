class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        
        # check length
        if len(password) < 8:
            return False
        # check special characters
        special_characters = "!@#$%^&*()-+"
        if not any(c in special_characters for c in password):
            return False
        # check digits
        if not any(c.isdigit() for c in password):
            return False
        # check uppercase
        if not any(c.isupper() for c in password):
            return False
        # check lowercase
        if not any(c.islower() for c in password):
            return False
        # check adjacent duplicates
        for i in range(len(password)-1):
            if password[i] == password[i+1]:
                return False
        return True