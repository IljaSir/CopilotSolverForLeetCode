class Solution:
    def numTeams(self, rating: List[int]) -> int:
        
        n = len(rating)
        res = 0
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    if rating[i] < rating[j] < rating[k] or rating[i] > rating[j] > rating[k]:
                        res += 1
        return res