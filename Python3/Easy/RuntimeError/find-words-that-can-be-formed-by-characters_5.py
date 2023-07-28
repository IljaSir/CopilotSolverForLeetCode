class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        def is_good(word):
            for c in word:
                if c not in chars:
                    return False
                else:
                    chars.remove(c)
            return True
        return sum([len(word) for word in words if is_good(list(word))])