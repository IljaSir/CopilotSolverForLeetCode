class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        
        def count(s):
            return sum(1 for i in range(len(s)) if s.startswith(target[:i]) and s.endswith(target[i:]))
        return sum(count(s) for s in nums)