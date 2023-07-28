class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        def get_palindrome_length(word1, word2):
            if word1[0] == word2[1] and word1[1] == word2[0]:
                return len(word1)
            return 0
        all_palindromes = {}
        for word in words:
            if word[0] == word[1]:
                all_palindromes[word] = all_palindromes.get(word, 0) + 1
        palindromes = []
        for word1 in words:
            for word2 in words:
                if word1 == word2:
                    continue
                palindrome_length = get_palindrome_length(word1, word2)
                if palindrome_length > 0:
                    palindromes.append(palindrome_length)
        palindromes = sorted(palindromes, reverse=True)
        for i, palindrome in enumerate(palindromes):
            if palindrome % 2 == 0:
                return palindrome
        if palindromes:
            return palindromes[0]
        return 0