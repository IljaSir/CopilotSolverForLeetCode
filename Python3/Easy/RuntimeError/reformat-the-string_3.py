class Solution:
    def reformat(self, s: str) -> str:
        
        # 1st solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # numbers = [c for c in s if c.isdigit()]
        # letters = [c for c in s if c.isalpha()]
        # if abs(len(numbers) - len(letters)) > 1:
        #     return ""
        # if len(numbers) > len(letters):
        #     numbers, letters = letters, numbers
        # return "".join(a + b for a, b in zip(letters, numbers + [""]))

        # 2nd solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        numbers = [c for c in s if c.isdigit()]
        letters = [c for c in s if c.isalpha()]
        if abs(len(numbers) - len(letters)) > 1:
            return ""
        if len(numbers) > len(letters):
            numbers, letters = letters, numbers
        return "".join(a + b for a, b in zip(letters, numbers))

        # 3rd solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        numbers = [c for c in s if c.isdigit()]
        letters = [c for c in s if c.isalpha()]
        if abs(len(numbers) - len(letters)) > 1:
            return ""
        if len(numbers) > len(letters):
            numbers, letters = letters, numbers
        return "".join(a + b for a, b in zip(letters, numbers + [""]))

        # 4th solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        numbers = [c for c in s if c.isdigit()]
        letters = [c for c in s if c.isalpha()]
        if abs(len(numbers) - len(letters)) > 1:
            return ""
        if len(numbers) > len(letters):
            numbers, letters = letters, numbers
        return "".join(a + b for a, b in zip(letters, numbers + [""]))

        # 5th solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        numbers = [c for c in s if c.isdigit()]
        letters = [c for c in s if c.isalpha()]
        if abs(len(numbers)