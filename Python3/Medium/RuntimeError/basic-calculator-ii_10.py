class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(" ", "")
        s = s.replace("-", "+-")
        s = s.replace("*", "+*")
        s = s.replace("
        return res