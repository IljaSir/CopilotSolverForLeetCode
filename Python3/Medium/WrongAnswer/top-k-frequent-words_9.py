class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        # Time  complexity: O(N log N)
        # Space complexity: O(N)
        return [w for w, _ in Counter(words).most_common(k)]