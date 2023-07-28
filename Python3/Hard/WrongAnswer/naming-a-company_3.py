class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        def swap(s, i, j):
            return s[:i] + s[j] + s[i+1:j] + s[i] + s[j+1:]
        res = set()
        for i in range(len(ideas)):
            for j in range(i+1, len(ideas)):
                ideaA, ideaB = ideas[i], ideas[j]
                new_name1 = swap(ideaA, 0, 0) + ' ' + swap(ideaB, 0, 0)
                new_name2 = swap(ideaB, 0, 0) + ' ' + swap(ideaA, 0, 0)
                if new_name1 not in ideas:
                    res.add(new_name1)
                if new_name2 not in ideas:
                    res.add(new_name2)
        return len(res)