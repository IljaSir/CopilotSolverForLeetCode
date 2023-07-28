class Solution:
    def reverseWords(self, s: str) -> str:
        
        # return " ".join([word[::-1] for word in s.split(" ")])
        return " ".join(map(lambda x: x[::-1], s.split(" ")))