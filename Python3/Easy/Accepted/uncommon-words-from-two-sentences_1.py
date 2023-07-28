class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        word_count = defaultdict(int)
        for word in s1.split():
            word_count[word] += 1
        for word in s2.split():
            word_count[word] += 1
        return [word for word, count in word_count.items() if count == 1]