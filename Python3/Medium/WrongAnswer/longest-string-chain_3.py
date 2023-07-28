class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        
        words.sort(key=len)
        word_to_max_chain = {}
        max_chain = 1
        for word in words:
            max_chain = 1
            for i in range(len(word)):
                predecessor = word[:i] + word[i+1:]
                if predecessor in word_to_max_chain:
                    max_chain = max(max_chain, word_to_max_chain[predecessor] + 1)
            word_to_max_chain[word] = max_chain
        return max_chain