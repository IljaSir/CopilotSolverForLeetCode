class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        def get_key(word):
            return tuple((ord(char) - ord(word[0])) % 26 for char in word)
        groups = {}
        for word in words:
            key = get_key(word)
            if key not in groups:
                groups[key] = set()
            groups[key].add(word)
        return max(len(group) for group in groups.values()), max(len(group) for group in groups.values())