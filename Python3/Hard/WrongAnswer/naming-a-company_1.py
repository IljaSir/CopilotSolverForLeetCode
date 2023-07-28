class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        res = set()
        for i in range(len(ideas)):
            for j in range(i+1, len(ideas)):
                ideaA, ideaB = ideas[i], ideas[j]
                if ideaA[0] == ideaB[0]:
                    continue
                newIdeaA = ideaB[0] + ideaA[1:]
                newIdeaB = ideaA[0] + ideaB[1:]
                if newIdeaA not in ideas and newIdeaB not in ideas:
                    res.add(newIdeaA + ' ' + newIdeaB)
        return len(res)