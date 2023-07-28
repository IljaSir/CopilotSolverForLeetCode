class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        for i in range(len(words)):
            if s == "".join(words[:i+1]):
                return True
        return False