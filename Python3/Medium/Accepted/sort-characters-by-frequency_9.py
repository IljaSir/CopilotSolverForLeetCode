class Solution:
    def frequencySort(self, s: str) -> str:
        
        import collections
        return ''.join([k*v for k,v in collections.Counter(s).most_common()])