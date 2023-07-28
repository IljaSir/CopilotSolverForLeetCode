class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if not s or not words:
            return []
        word_len = len(words[0])
        word_cnt = len(words)
        word_dict = {}
        for word in words:
            if word in word_dict:
                word_dict[word] += 1
            else:
                word_dict[word] = 1
        result = []
        for i in range(len(s) - word_len * word_cnt + 1):
            j = 0
            temp_dict = {}
            while j < word_cnt:
                word = s[i + j * word_len: i + (j + 1) * word_len]
                if word in word_dict:
                    if word in temp_dict:
                        temp_dict[word] += 1
                    else:
                        temp_dict[word] = 1
                    if temp_dict[word] > word_dict[word]:
                        break
                else:
                    break
                j += 1
            if j == word_cnt:
                result.append(i)
        return result