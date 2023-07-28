class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if len(words) == 0:
            return []
        word_len = len(words[0])
        word_dict = {}
        for word in words:
            if word not in word_dict:
                word_dict[word] = 1
            else:
                word_dict[word] += 1
        result = []
        for i in range(0, len(s) - len(words) * word_len + 1):
            word_dict_copy = word_dict.copy()
            for j in range(0, len(words)):
                word = s[i + j * word_len:i + j * word_len + word_len]
                if word not in word_dict_copy:
                    break
                else:
                    word_dict_copy[word] -= 1
                    if word_dict_copy[word] == 0:
                        del word_dict_copy[word]
            if len(word_dict_copy) == 0:
                result.append(i)
        return result