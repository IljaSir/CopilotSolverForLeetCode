class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def is_palindrome(num):
            return str(num) == str(num)[::-1]
        
        def is_superpalindrome(num):
            return is_palindrome(num) and is_palindrome(num ** 2)
        
        left = int(left)
        right = int(right)
        # print(left, right)
        res = 0
        for i in range(1, 10 ** 5):
            s = str(i)
            # print(s)
            s2 = s + s[:-1][::-1]
            # print(s2)
            num = int(s2) ** 2
            if num > right:
                break
            if num >= left and is_palindrome(num):
                res += 1
        for i in range(1, 10 ** 5):
            s = str(i)
            # print(s)
            s2 = s + s[::-1]
            # print(s2)
            num = int(s2) ** 2
            if num > right:
                break
            if num >= left and is_palindrome(num):
                res += 1
        return res