class Solution:
    def maxRepOpt1(self, text: str) -> int:
        
        # 30 min
        # 1. count the number of each char
        # 2. find the longest substring with repeated char
        # 3. try to swap a different char
        # 4. find the longest substring with repeated char
        # 5. return the max of the two
        char_to_count = {}
        for char in text:
            if char not in char_to_count:
                char_to_count[char] = 0
            char_to_count[char] += 1
        max_len = 0
        for char in char_to_count:
            max_len = max(max_len, char_to_count[char])
        for i in range(len(text)):
            for j in range(i + 1, len(text)):
                if text[i] != text[j]:
                    char_to_count[text[i]] -= 1
                    char_to_count[text[j]] += 1
                    max_len = max(max_len, self._get_max_len(text, char_to_count))
                    char_to_count[text[i]] += 1
                    char_to_count[text[j]] -= 1
        return max_len