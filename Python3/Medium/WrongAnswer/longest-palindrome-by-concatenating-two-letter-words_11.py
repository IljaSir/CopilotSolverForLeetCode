class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        ans = 0
        # 1. Count the number of words with the same first and last letter
        # 2. Count the number of words with the same last letter and the number of words with the same first letter
        # 3. Count the number of words with the same first and last letter, but not the same word
        # 4. If the number of words with the same first and last letter is odd, add 1 to the answer
        # 5. Add the number of words with the same last letter and the number of words with the same first letter to the answer
        # 6. Return the answer
        words = sorted(words)
        words_with_same_first_and_last_letter = 0
        words_with_same_first_letter = 0
        words_with_same_last_letter = 0
        for i, word in enumerate(words):
            if i > 0 and word[0] == words[i-1][0]:
                words_with_same_first_letter += 1
            if i > 0 and word[1] == words[i-1][1]:
                words_with_same_last_letter += 1
            if word[0] == word[1]:
                words_with_same_first_and_last_letter += 1
        if words_with_same_first_and_last_letter % 2 == 1:
            ans += 1
        ans += words_with_same_first_letter + words_with_same_last_letter
        return ans
def longestPalindrome(self, words: List[str]) -> int:
        from collections import Counter
        from functools import reduce
        def is_palindrome(s):
            return s == s[::-1]
        def get_longest_palindrome(s):
            if is_palindrome(s):
                return s
            else:
                return s[0] + get_longest_palindrome(s[1:])
        def get_all_palindromes(s):
            if is_palindrome(s):
                return [s]
            else:
                return [s[0] + x for x in get_all_palindromes(s[1:])]
        words = [w for w in words if is_palindrome(w)]
        words = [get_longest_palindrome(w) for w in words]
        counter = Counter(words)
        result = 0
        for c in counter:
            if counter[c] > 1:
                result += len(c) * 2
                counter[c] -= 2
        for c in counter:
            if counter[c] > 0:
                result += len(c)
                break
        return result