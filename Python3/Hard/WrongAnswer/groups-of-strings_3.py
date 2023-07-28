class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        def get_key(word):
            key = []
            for i in range(1, len(word)):
                key.append((ord(word[i]) - ord(word[i-1])) % 26)
            return tuple(key)
        
        groups = {}
        for word in words:
            key = get_key(word)
            if key not in groups:
                groups[key] = [word]
            else:
                groups[key].append(word)
        
        return [len(groups), max([len(groups[key]) for key in groups]) if groups else 0]