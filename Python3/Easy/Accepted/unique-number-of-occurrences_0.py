class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        
        # return len(set(collections.Counter(arr).values())) == len(collections.Counter(arr))
        return len(set(collections.Counter(arr).values())) == len(collections.Counter(arr).values())