class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        chars_dict = {}
        for char in chars:
            if char not in chars_dict:
                chars_dict[char] = 1
            else:
                chars_dict[char] += 1
        result = 0
        for word in words:
            word_dict = {}
            for char in word:
                if char not in word_dict:
                    word_dict[char] = 1
                else:
                    word_dict[char] += 1
            for char in word_dict:
                if char not in chars_dict:
                    break
                elif word_dict[char] > chars_dict[char]:
                    break
            else:
                result += len(word)
        return result