class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        def swapName(name1, name2):
            return name1[0] + name2[1:], name2[0] + name1[1:]
        res = set()
        for i in range(len(ideas)):
            for j in range(i + 1, len(ideas)):
                name1, name2 = swapName(ideas[i], ideas[j])
                if name1 != ideas[i] and name1 != ideas[j] and name2 != ideas[i] and name2 != ideas[j]:
                    res.add(name1 + " " + name2)
                    res.add(name2 + " " + name1)
        return len(res)