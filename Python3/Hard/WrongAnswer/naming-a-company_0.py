class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        s = set()
        for i in range(len(ideas)):
            for j in range(i+1, len(ideas)):
                a, b = ideas[i], ideas[j]
                if a[0] != b[0]:
                    new_a = b[0] + a[1:]
                    new_b = a[0] + b[1:]
                    if new_a not in ideas and new_b not in ideas:
                        s.add(new_a+' '+new_b)
        return len(s)