class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        
        return [sum(word.startswith(words[i][:j]) for i in range(len(words))) for j in range(1, len(words[0])+1)]