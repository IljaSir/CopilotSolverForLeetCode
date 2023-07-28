class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        
        return max(map(len, map(str.split, sentences)))