class Solution:
    def capitalizeTitle(self, title: str) -> str:
        
        return ' '.join([word[0].upper() + word[1:].lower() if len(word) > 2 else word.lower() for word in title.split(' ')])