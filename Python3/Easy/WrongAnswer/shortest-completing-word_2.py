class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        
        def is_completing_word(word, licensePlate):
            word_count = collections.Counter(word)
            license_count = collections.Counter(licensePlate)
            for k, v in license_count.items():
                if k.isalpha() and word_count[k.lower()] < v:
                    return False
            return True
        words.sort(key=len)
        for word in words:
            if is_completing_word(word, licensePlate):
                return word