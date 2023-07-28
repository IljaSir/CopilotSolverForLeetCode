class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        def get_word_count(word):
            word_count = {}
            for char in word:
                if char in word_count:
                    word_count[char] += 1
                else:
                    word_count[char] = 1
            return word_count
        words2_word_count = {}
        for word in words2:
            word_count = get_word_count(word)
            for char, count in word_count.items():
                if char in words2_word_count:
                    words2_word_count[char] = max(words2_word_count[char], count)
                else:
                    words2_word_count[char] = count
        universal_words = []
        for word in words1:
            word_count = get_word_count(word)
            is_universal = True
            for char, count in words2_word_count.items():
                if char not in word_count or word_count[char] < count:
                    is_universal = False
                    break
            if is_universal:
                universal_words.append(word)
        return universal_words