class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if not words or not s:
            return []
        word_len = len(words[0])
        word_num = len(words)
        word_total_len = word_len * word_num
        if len(s) < word_total_len:
            return []
        word_dict = {}
        for word in words:
            if word not in word_dict:
                word_dict[word] = 1
            else:
                word_dict[word] += 1
        res = []
        for i in range(len(s) - word_total_len + 1):
            tmp_dict = {}
            for j in range(i, i + word_total_len, word_len):
                tmp_word = s[j:j+word_len]
                if tmp_word in word_dict:
                    if tmp_word not in tmp_dict:
                        tmp_dict[tmp_word] = 1
                    else:
                        tmp_dict[tmp_word] += 1
                else:
                    break
            if tmp_dict == word_dict:
                res.append(i)
        return res