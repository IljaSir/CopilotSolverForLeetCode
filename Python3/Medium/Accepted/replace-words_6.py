class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        d = set(dictionary)
        return " ".join([min([w[:i] for i in range(1, len(w)) if w[:i] in d] or [w]) for w in sentence.split()])