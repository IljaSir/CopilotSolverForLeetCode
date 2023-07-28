class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        word_count = {}
        for word in words:
            if word not in word_count:
                word_count[word] = 1
            else:
                word_count[word] += 1
        word_count = sorted(word_count.items(), key=lambda x: (-x[1], x[0]))
        return [word[0] for word in word_count[:k]]