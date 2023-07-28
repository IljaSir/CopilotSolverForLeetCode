class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        nums = [str(i) for i in range(1, n+1)]
        fact = [1]
        for i in range(1, n):
            fact.append(fact[-1] * i)
        k -= 1
        ans = []
        for i in range(n-1, -1, -1):
            idx = k // fact[i]
            ans.append(nums.pop(idx))
            k -= idx * fact[i]
        return "".join(ans)