class Solution:
    def romanToInt(self, s: str) -> int:
        
        roman_dict = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        roman_list = list(s)
        total = 0
        for i in range(len(roman_list)):
            if i == len(roman_list) - 1:
                total += roman_dict[roman_list[i]]
                return total
            if roman_dict[roman_list[i]] >= roman_dict[roman_list[i + 1]]:
                total += roman_dict[roman_list[i]]
            else:
                total -= roman_dict[roman_list[i]]