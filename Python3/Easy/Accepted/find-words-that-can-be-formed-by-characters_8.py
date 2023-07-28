class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        
        # 1. Get the count of each character in chars
        # 2. Iterate each word in words
        # 3. Iterate each character in word
        # 4. If the count of the character in word is greater than the count of the character in chars, break
        # 5. If the count of the character in word is less than or equal to the count of the character in chars, add the length of the word to the result
        
        # Time: O(n)
        # Space: O(n)
        
        # Get the count of each character in chars
        chars_count = {}
        for char in chars:
            chars_count[char] = chars_count.get(char, 0) + 1
        
        # Iterate each word in words
        result = 0
        for word in words:
            # Iterate each character in word
            word_count = {}
            for char in word:
                word_count[char] = word_count.get(char, 0) + 1
            # If the count of the character in word is greater than the count of the character in chars, break
            # If the count of the character in word is less than or equal to the count of the character in chars, add the length of the word to the result
            for char in word:
                if word_count[char] > chars_count.get(char, 0):
                    break
            else:
                result += len(word)
        
        return result