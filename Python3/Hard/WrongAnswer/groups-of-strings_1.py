class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        groups = {}
        for word in words:
            key = tuple((ord(c) - ord(word[0])) % 26 for c in word)
            groups[key] = groups.get(key, []) + [word]
        return [len(groups), max(len(group) for group in groups.values())]