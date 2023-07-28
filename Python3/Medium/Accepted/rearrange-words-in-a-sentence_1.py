class Solution:
    def arrangeWords(self, text: str) -> str:
        
        # Solution 1 - 28 ms
        """
        return text[0].lower() + " ".join(sorted(text.split(), key=len)).capitalize()
        """
        # Solution 2 - 20 ms
        words = text.lower().split()
        words.sort(key=len)
        words[0] = words[0].capitalize()
        return " ".join(words)