class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        
        count = 0
        for i in range(len(dominoes)):
            for j in range(i + 1, len(dominoes)):
                if dominoes[i][0] == dominoes[j][0] and dominoes[i][1] == dominoes[j][1]:
                    count += 1
                elif dominoes[i][0] == dominoes[j][1] and dominoes[i][1] == dominoes[j][0]:
                    count += 1
        return count