class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        
        if len(password) < 8:
            return False
        if len(password) > 100:
            return False
        if not any(char.isdigit() for char in password):
            return False
        if not any(char.isupper() for char in password):
            return False
        if not any(char.islower() for char in password):
            return False
        if not any(char in "!@#$%^&*()-+" for char in password):
            return False
        for i in range(0, len(password) - 2):
            if password[i] == password[i + 1] == password[i + 2]:
                return False
        return True