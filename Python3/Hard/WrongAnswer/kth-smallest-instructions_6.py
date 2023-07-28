class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        def comb(n, k):
            if k == 0:
                return 1
            return comb(n, k - 1) * (n - k + 1) // k
        row, col = destination
        ans = ""
        for i in range(row + col):
            if col == 0:
                ans += "H"
                continue
            if row == 0:
                ans += "V"
                continue
            if k <= comb(row + col - 1, col):
                ans += "H"
                col -= 1
            else:
                ans += "V"
                k -= comb(row + col - 1, col)
                row -= 1
        return ans