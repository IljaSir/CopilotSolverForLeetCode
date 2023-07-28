class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def is_palindrome(word):
            return word == word[::-1]
        
        def find_word(word):
            return word_to_index.get(word, -1)
        
        def find_reverse_word(word):
            return word_to_index.get(word[::-1], -1)
        
        def find_prefix(word):
            for i in range(len(word)):
                if is_palindrome(word[i:]):
                    return find_word(word[:i])
            return -1
        
        def find_suffix(word):
            for i in range(len(word)):
                if is_palindrome(word[:i+1]):
                    return find_word(word[i+1:])
            return -1
        
        word_to_index = {}
        for i, word in enumerate(words):
            word_to_index[word] = i
        
        result = []
        for i, word in enumerate(words):
            if word == "":
                for j in range(len(words)):
                    if i == j: continue
                    if is_palindrome(words[j]):
                        result.append([i, j])
                        result.append([j, i])
                continue
            
            reverse_word_index = find_reverse_word(word)
            if reverse_word_index != -1 and reverse_word_index != i:
                result.append([i, reverse_word_index])
            
            prefix_index = find_prefix(word)
            if prefix_index != -1:
                result.append([i, prefix_index])
            
            suffix_index = find_suffix(word)
            if suffix_index != -1:
                result.append([suffix_index, i])
        
        return result