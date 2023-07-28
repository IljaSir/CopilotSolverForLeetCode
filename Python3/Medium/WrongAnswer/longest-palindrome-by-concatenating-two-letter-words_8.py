class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(1)
        def is_palindrome(word):
            return word[0] == word[1]
        
        ans = 0
        counter = collections.Counter(word for word in words if is_palindrome(word))
        ans += sum(v - v % 2 for v in counter.values())
        for word in words:
            if not is_palindrome(word):
                rev = word[::-1]
                if rev in counter:
                    ans += 2
                    counter[rev] -= 1
                    if counter[rev] == 0:
                        del counter[rev]
        return ans