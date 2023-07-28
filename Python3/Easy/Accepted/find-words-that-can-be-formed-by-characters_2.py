class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        output = 0
        chars_map = dict()
        for char in chars:
            if char in chars_map:
                chars_map[char] += 1
            else:
                chars_map[char] = 1
        for word in words:
            word_map = dict()
            for char in word:
                if char in word_map:
                    word_map[char] += 1
                else:
                    word_map[char] = 1
            is_good = True
            for char in word:
                if char not in chars_map or word_map[char] > chars_map[char]:
                    is_good = False
                    break
            if is_good:
                output += len(word)
        return output