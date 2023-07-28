class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        def count_unique(words: List[str]) -> int:
            count = 0
            seen = set()
            for word in words:
                if word in seen:
                    continue
                if words.count(word) == 1:
                    count += 1
                seen.add(word)
            return count
        return count_unique(words1) + count_unique(words2)