class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        s_counter = collections.Counter(s)
        t_counter = collections.Counter(t)
        return sum((s_counter - t_counter).values())