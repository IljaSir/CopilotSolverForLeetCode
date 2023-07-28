class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        char_dict = {}
        for char in chars:
            if char not in char_dict:
                char_dict[char] = 1
            else:
                char_dict[char] += 1
        count = 0
        for word in words:
            word_dict = {}
            for char in word:
                if char not in word_dict:
                    word_dict[char] = 1
                else:
                    word_dict[char] += 1
            for char in word_dict:
                if char not in char_dict or word_dict[char] > char_dict[char]:
                    break
            else:
                count += len(word)
        return count