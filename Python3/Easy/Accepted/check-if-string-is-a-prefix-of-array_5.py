class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        s1 = ""
        for w in words:
            s1 += w
            if s1 == s:
                return True
        return False