class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        def nCr(n, r):
            f = math.factorial
            return f(n) // f(r) // f(n - r)
        def count_path(x, y):
            if x == 0 or y == 0:
                return 1
            if (x, y) in memo:
                return memo[(x, y)]
            memo[(x, y)] = count_path(x - 1, y) + count_path(x, y - 1)
            return memo[(x, y)]
        memo = {}
        res = ''
        x, y = destination
        while x > 0 and y > 0:
            left = count_path(x - 1, y)
            if k <= left:
                res += 'H'
                x -= 1
            else:
                res += 'V'
                y -= 1
                k -= left
        res += 'H' * x
        res += 'V' * y
        return res