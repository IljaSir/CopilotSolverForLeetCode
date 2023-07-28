class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        
        if len(palindrome) <= 1:
            return ""
        if len(palindrome) == 2:
            if palindrome[0] == "a":
                return palindrome[0] + "b"
            else:
                return "a" + palindrome[1]
        if len(palindrome) % 2 == 0:
            for i in range(len(palindrome) // 2):
                if palindrome[i] != "a":
                    return palindrome[0:i] + "a" + palindrome[i + 1:]
            return palindrome[0:len(palindrome) // 2] + "b" + palindrome[len(palindrome) // 2 + 1:]
        else:
            for i in range(len(palindrome) // 2):
                if palindrome[i] != "a":
                    return palindrome[0:i] + "a" + palindrome[i + 1:]
            return palindrome[0:len(palindrome) // 2] + "b" + palindrome[len(palindrome) // 2 + 1:]