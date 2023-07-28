class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        
        skill.sort()
        n = len(skill)
        i = 0
        j = n - 1
        total = 0
        while i < j:
            total += skill[i] * skill[j]
            i += 1
            j -= 1
        return total