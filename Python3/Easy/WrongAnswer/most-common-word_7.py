class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        banned_words = set(banned)
        word_count = {}
        max_count = 0
        max_word = ""
        for word in paragraph.split():
            word = word.strip("!?',;.").lower()
            if word not in banned_words:
                count = word_count.get(word, 0) + 1
                word_count[word] = count
                if count > max_count:
                    max_count = count
                    max_word = word
        return max_word