class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1_words = s1.split(' ')
        s2_words = s2.split(' ')
        s1_words_set = set(s1_words)
        s2_words_set = set(s2_words)
        s1_words_set_minus_s2 = s1_words_set.difference(s2_words_set)
        s2_words_set_minus_s1 = s2_words_set.difference(s1_words_set)
        s1_words_set_minus_s2 = [w for w in s1_words_set_minus_s2 if s1_words.count(w) == 1]
        s2_words_set_minus_s1 = [w for w in s2_words_set_minus_s1 if s2_words.count(w) == 1]
        return s1_words_set_minus_s2 + s2_words_set_minus_s1