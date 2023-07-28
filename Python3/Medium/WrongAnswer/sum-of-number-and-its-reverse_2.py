class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        
        def is_palindrome(num):
            return str(num) == str(num)[::-1]
        def is_sum_of_number_and_its_reverse(num):
            for i in range(1, num):
                if is_palindrome(i) and num - i == int(str(i)[::-1]):
                    return True
            return False
        return is_sum_of_number_and_its_reverse(num)