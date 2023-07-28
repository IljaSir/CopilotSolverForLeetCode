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