class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        
        # 1. At least 8 characters
        if len(password) < 8:
            return False

        # 2. It contains at least one lowercase letter.
        if not any(c.islower() for c in password):
            return False

        # 3. It contains at least one uppercase letter.
        if not any(c.isupper() for c in password):
            return False

        # 4. It contains at least one digit.
        if not any(c.isdigit() for c in password):
            return False

        # 5. It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
        if not any(c in "!@#$%^&*()-+" for c in password):
            return False

        # 6. It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
        if any(password[i] == password[i + 1] for i in range(len(password) - 1)):
            return False

        return True