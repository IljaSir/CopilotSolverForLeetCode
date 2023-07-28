class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        
        def get_words_within_two_edits(word):
            words_within_two_edits = set()
            for i in range(len(word)):
                for j in range(26):
                    new_word = word[:i] + chr(ord('a') + j) + word[i + 1:]
                    words_within_two_edits.add(new_word)
            for i in range(len(word)):
                for j in range(26):
                    new_word = word[:i] + chr(ord('a') + j) + word[i:]
                    words_within_two_edits.add(new_word)
            for i in range(len(word)):
                for j in range(26):
                    new_word = word[:i] + chr(ord('a') + j) + word[i + 1:]
                    words_within_two_edits.add(new_word)
            return words_within_two_edits
        dictionary_set = set(dictionary)
        result = []
        for word in queries:
            words_within_two_edits = get_words_within_two_edits(word)
            if any(w in dictionary_set for w in words_within_two_edits):
                result.append(word)
        return result