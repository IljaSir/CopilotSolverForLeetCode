class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        cur = 1
        k -= 1
        while k > 0:
            steps = self.getSteps(n, cur, cur+1)
            if steps <= k:
                cur += 1
                k -= steps
            else:
                cur *= 10
                k -= 1
        return cur