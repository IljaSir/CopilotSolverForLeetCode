class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if len(words) == 0:
            return []
        word_len = len(words[0])
        word_count = len(words)
        word_dict = {}
        for word in words:
            if word in word_dict:
                word_dict[word] += 1
            else:
                word_dict[word] = 1
        res = []
        for i in range(len(s) - word_len * word_count + 1):
            temp_dict = word_dict.copy()
            for j in range(word_count):
                word = s[i + j * word_len : i + (j + 1) * word_len]
                if word in temp_dict:
                    temp_dict[word] -= 1
                    if temp_dict[word] == 0:
                        temp_dict.pop(word)
                else:
                    break
            if len(temp_dict) == 0:
                res.append(i)
        return res