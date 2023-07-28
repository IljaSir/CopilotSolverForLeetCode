class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        # 1. Count the number of all characters
        # 2. Check if the number of all characters is divisible by the number of words
        # 3. If yes, return True. If no, return False.
        # 4. Time complexity: O(n)
        # 5. Space complexity: O(1)
        num_chars = [0] * 26
        for word in words:
            for char in word:
                num_chars[ord(char) - ord('a')] += 1
        return all(num_char % len(words) == 0 for num_char in num_chars)