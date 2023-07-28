class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        word_dict = {}
        for word in words:
            if word not in word_dict:
                word_dict[word] = 1
            else:
                word_dict[word] += 1
        word_dict = sorted(word_dict.items(), key=lambda x: (-x[1], x[0]))
        return [word_dict[i][0] for i in range(k)]