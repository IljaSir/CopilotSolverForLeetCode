class Solution:
    def robotWithString(self, s: str) -> str:
        
        # 1. Get the smallest character in s
        # 2. Get the index of the smallest character in s
        # 3. Get the first character of s, and compare it with the smallest character in s
        # 4. If the first character of s is smaller than the smallest character in s, then append the first character of s to the end of t
        # 5. If the first character of s is greater than the smallest character in s, then append the smallest character to the end of t
        # 6. If the first character of s is equal to the smallest character in s, then
        #    6.1 If the second character of s is smaller than the smallest character in s, then append the first character of s to the end of t
        #    6.2 If the second character of s is greater than the smallest character in s, then append the smallest character to the end of t
        #    6.3 If the second character of s is equal to the smallest character in s, then
        #        6.3.1 If the third character of s is smaller than the smallest character in s, then append the first character of s to the end of t
        #        6.3.2 If the third character of s is greater than the smallest character in s, then append the smallest character to the end of t
        #        6.3.3 If the third character of s is equal to the smallest character in s, then
        #