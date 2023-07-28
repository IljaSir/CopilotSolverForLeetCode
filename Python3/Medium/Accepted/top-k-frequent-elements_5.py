class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        return [a[0] for a in collections.Counter(nums).most_common(k)]