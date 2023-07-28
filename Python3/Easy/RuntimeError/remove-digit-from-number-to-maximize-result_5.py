class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        # Remove the first occurrence of digit from number
        # Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized.
        # The test cases are generated such that digit occurs at least once in number.
        # 2 <= number.length <= 100
        # number consists of digits from '1' to '9'.
        # digit is a digit from '1' to '9'.
        # digit occurs at least once in number.
        # number = "123", digit = "3"
        # number = "1231", digit = "1"
        # number = "551", digit = "5"
        # number = "123456789", digit = "1"
        # number = "123456789", digit = "9"
        # number = "123456789", digit = "5"
        # number = "123456789", digit = "0"
        # number = "123456789", digit = "2"
        # number = "123456789", digit = "3"
        # number = "123456789", digit = "4"
        # number = "123456789", digit = "5"
        # number = "123456789", digit = "6"
        # number = "123456789", digit = "7"
        # number = "123456789", digit = "8"
        # number = "123456789", digit = "9"
        # number = "123456789", digit = "0"
        # number = "123456789", digit = "1"
        # number = "123456789", digit = "2"
        # number = "123456789", digit = "3"
        # number = "123456789", digit = "4"
        # number = "123456789", digit = "5