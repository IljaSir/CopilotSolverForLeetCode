class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        # A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
        # For example, "ace" is a subsequence of "abcde".
        # Example 1:
        # Input: s = "abcde", words = ["a","bb","acd","ace"]
        # Output: 3
        # Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
        # Example 2:
        # Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
        # Output: 2
        # Constraints:
        # 1 <= s.length <= 5 * 10^4
        # 1 <= words.length <= 5000
        # 1 <= words[i].length <= 50
        # s and words[i] consist of only lowercase English letters.
        # 1. We need to iterate over the words list
        # 2. For each word in the words list, we need to check if it is a subsequence of s
        # 3. If it is a subsequence of s, we need to increment the result counter by 1
        # 4. We need to return the result counter
        # 1. We need to iterate over the words list
        # 2. For each word in the words list, we need to check if it is a subsequence of s
        # 3. If it is a subsequence of s, we need to increment the result counter by 1
        # 4. We need to return the result counter
        result = 0
        for word in words:
            # 2. For each word in the words list, we need to check if it is a subsequence of s
            # 3. If it is a subsequence of s, we need to increment the result counter by 1
            # 4. We need to return the result counter
            if self.is_subsequence(word, s):
                result += 1
        return result