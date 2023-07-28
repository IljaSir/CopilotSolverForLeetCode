class Solution:
    def oddString(self, words: List[str]) -> str:
        
        def get_diff(w):
            return "".join(str(ord(w[i + 1]) - ord(w[i])) for i in range(len(w) - 1))
        d = get_diff(words[0])
        for w in words:
            if d != get_diff(w):
                return w