class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) == 1:
            return s
        else:
            # 1. Create a list of all possible substrings
            substrings = []
            for i in range(len(s)):
                for j in range(i+1, len(s)+1):
                    substrings.append(s[i:j])
            # 2. Check if each substring is a palindrome
            palindromes = []
            for substring in substrings:
                if substring == substring[::-1]:
                    palindromes.append(substring)
            # 3. Find the longest palindrome
            longest = palindromes[0]
            for palindrome in palindromes:
                if len(palindrome) > len(longest):
                    longest = palindrome
            return longest