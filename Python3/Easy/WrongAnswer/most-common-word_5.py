class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        paragraph = [c.lower() for c in paragraph if c.isalpha() or c == ' ']
        paragraph = ''.join(paragraph).split(' ')
        word_dict = {}
        for word in paragraph:
            if word in word_dict:
                word_dict[word] += 1
            else:
                word_dict[word] = 1
        word_dict = {k: v for k, v in sorted(word_dict.items(), key=lambda item: item[1])}
        for k, v in word_dict.items():
            if k not in banned:
                return k
        return None