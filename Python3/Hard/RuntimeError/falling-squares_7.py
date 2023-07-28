class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        # Sweep line
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # N = len(positions)
        # res = []
        # cur = 0
        # h = [0] * (positions[-1][0] + positions[-1][1])
        # for p in positions:
        #     left, side = p
        #     right = left + side
        #     cur = max(cur, max(h[left:right]) + side)
        #     res.append(cur)
        #     for i in range(left, right):
        #         h[i] = max(h[i], cur)
        # return res
        
        # Segment Tree
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        # N = len(positions)
        # res = []
        # cur = 0
        # h = [0] * (positions[-1][0] + positions[-1][1])
        # def update(l, r, val, i, j, k):
        #     if l > r or l > j or r < i:
        #         return
        #     if l <= i and r >= j:
        #         h[k] = max(h[k], val)
        #         return
        #     mid = (i + j) >> 1
        #     update(l, r, val, i, mid, k << 1)
        #     update(l, r, val, mid + 1, j, k << 1 | 1)
        # for p in positions:
        #     left, side = p
        #     right = left + side
        #     cur = max(cur, max(h[left:right]) + side)
        #     res.append(cur)
        #     update(left, right - 1, cur, 0, len(h) - 1, 1)
        # return res
        
        # Binary Indexed Tree
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        N = len(positions)
        res = []
        cur = 0
        h = [0] * (positions[-1][0] + positions[-1][1])
        def update(i, val):
            while i < len(h):
                h[i] = max(h[i],