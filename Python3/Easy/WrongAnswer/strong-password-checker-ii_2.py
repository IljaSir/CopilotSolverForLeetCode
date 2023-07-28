class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        
        if len(password) < 8:
            return False
        if not any(c.islower() for c in password):
            return False
        if not any(c.isupper() for c in password):
            return False
        if not any(c.isdigit() for c in password):
            return False
        if not any(c in "!@#$%^&*()-+" for c in password):
            return False
        if any(password[i] == password[i+1] == password[i+2] for i in range(len(password)-2)):
            return False
        return True