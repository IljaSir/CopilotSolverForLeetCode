class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        word_dict = {}
        for word in words:
            if word not in word_dict:
                word_dict[word] = 1
            else:
                word_dict[word] += 1
        word_list = []
        for word, count in word_dict.items():
            word_list.append((word, count))
        word_list.sort(key=lambda x: (-x[1], x[0]))
        return [word for word, count in word_list[:k]]