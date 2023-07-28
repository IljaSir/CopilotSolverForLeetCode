class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        
        def is_good(word):
            for c in word:
                if word.count(c) > chars.count(c):
                    return False
            return True
        
        return sum([len(word) for word in words if is_good(word)])