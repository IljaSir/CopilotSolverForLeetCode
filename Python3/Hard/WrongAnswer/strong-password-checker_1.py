class Solution:
    def strongPasswordChecker(self, password: str) -> int:
        
        if len(password) < 6:
            return max(6 - len(password), 6 - len(password) - sum(c.isdigit() for c in password) - sum(c.islower() for c in password) - sum(c.isupper() for c in password))
        elif len(password) > 20:
            return max(len(password) - 20, len(password) - 20 - sum(c.isdigit() for c in password) - sum(c.islower() for c in password) - sum(c.isupper() for c in password))
        else:
            return max(6 - len(password) - sum(c.isdigit() for c in password) - sum(c.islower() for c in password) - sum(c.isupper() for c in password), sum(c.isdigit() for c in password) - 1, sum(c.islower() for c in password) - 1, sum(c.isupper() for c in password) - 1)