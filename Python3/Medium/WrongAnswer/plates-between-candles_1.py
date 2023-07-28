class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        return [s[left:right+1].count('*') for left, right in queries]