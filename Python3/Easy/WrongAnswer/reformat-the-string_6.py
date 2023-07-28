class Solution:
    def reformat(self, s: str) -> str:
        
        # 1. Get the number of letters and numbers
        # 2. Get the number of letters and numbers in the string
        # 3. Get the number of letters and numbers that need to be added
        # 4. Add the letters and numbers to the string in order
        # 5. Return the string
        num_letters = 0
        num_numbers = 0
        for char in s:
            if char.isalpha():
                num_letters += 1
            else:
                num_numbers += 1
        if abs(num_letters - num_numbers) > 1:
            return ""
        if num_letters > num_numbers:
            letters = True
        else:
            letters = False
        new_string = ""
        for char in s:
            if letters:
                if char.isalpha():
                    new_string += char
                    letters = False
            else:
                if char.isdigit():
                    new_string += char
                    letters = True
        return new_string