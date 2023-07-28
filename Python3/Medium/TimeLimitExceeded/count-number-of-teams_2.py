class Solution:
    def numTeams(self, rating: List[int]) -> int:
        
        n = len(rating)
        if n < 3:
            return 0
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                for k in range(j+1, n):
                    if rating[i] < rating[j] < rating[k] or rating[i] > rating[j] > rating[k]:
                        ans += 1
        return ans