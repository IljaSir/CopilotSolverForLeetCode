class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        return s == ''.join(words[:len(s)//min(len(w) for w in words)+1])