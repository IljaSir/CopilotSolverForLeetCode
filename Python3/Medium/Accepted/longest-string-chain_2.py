class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        
        words.sort(key=len)
        chain = {}
        for word in words:
            chain[word] = 1
            for i in range(len(word)):
                pre = word[:i] + word[i+1:]
                if pre in chain:
                    if chain[pre] + 1 > chain[word]:
                        chain[word] = chain[pre] + 1
        return max(chain.values())