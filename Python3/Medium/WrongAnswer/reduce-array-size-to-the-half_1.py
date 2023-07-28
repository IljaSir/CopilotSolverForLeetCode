class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        
        count = collections.Counter(arr)
        return sum(i >= len(arr) // 2 for i in itertools.accumulate(sorted(count.values(), reverse=True)))