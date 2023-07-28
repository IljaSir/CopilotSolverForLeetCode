class Solution:
    def toLowerCase(self, s: str) -> str:
        
        # return s.lower()
        return "".join([chr(ord(c)+32) if ord(c) >= 65 and ord(c) <= 90 else c for c in s])