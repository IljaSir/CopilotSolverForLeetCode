class Solution:
    def frequencySort(self, s: str) -> str:
        
        return ''.join([c * n for c, n in collections.Counter(s).most_common()])