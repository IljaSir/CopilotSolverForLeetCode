class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        def swap(s1, s2):
            return s1[0] + s2[1:], s2[0] + s1[1:]
        res = set()
        ideas = set(ideas)
        for i in range(len(ideas)):
            for j in range(i+1, len(ideas)):
                a, b = swap(list(ideas)[i], list(ideas)[j])
                if a not in ideas and b not in ideas:
                    res.add(a + ' ' + b)
        return len(res)