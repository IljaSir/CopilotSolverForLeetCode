class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        
        
        # max_words = 0
        # for sentence in sentences:
        #     words = sentence.split()
        #     if len(words) > max_words:
        #         max_words = len(words)
        # return max_words
        
        return max(map(len, sentences))