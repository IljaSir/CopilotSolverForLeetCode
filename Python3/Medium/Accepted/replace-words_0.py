class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        dictionary.sort(key=len)
        sentence = sentence.split()
        for i, word in enumerate(sentence):
            for root in dictionary:
                if word.startswith(root):
                    sentence[i] = root
                    break
        return ' '.join(sentence)