class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        seen = set()
        for i in range(len(ideas)):
            for j in range(len(ideas)):
                if i != j:
                    new = ideas[i][:1] + ideas[j][1:] + ' ' + ideas[j][:1] + ideas[i][1:]
                    if new not in seen:
                        seen.add(new)
        return len(seen)