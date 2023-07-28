class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        
        # Solution 1: simulation
        # O(n*k), O(n)
        # arr = [i for i in range(1, n+1)]
        # i = 0
        # while len(arr) > 1:
        #     i = (i+k-1) % len(arr)
        #     del arr[i]
        # return arr[0]

        # Solution 2: recursion
        # O(n), O(n)
        # def f(n, k):
        #     if n == 1:
        #         return 1
        #     return (f(n-1, k)+k) % n + 1
        # return f(n, k)

        # Solution 3: math
        # O(n), O(1)
        # https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1012265/Python-O(n)-with-math-explained
        # https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1012298/Python-3-lines-O(n)-with-explanation
        return 1 if n == 1 else (findTheWinner(n-1, k) + k - 1) % n + 1