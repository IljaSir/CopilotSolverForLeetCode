class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        # 1st solution: brute force
        # O(n^2) time | O(n) space
        # n = len(s)
        # res = []
        # for i in range(n):
        #     found = False
        #     for j in range(1, n):
        #         if s[i-j] == c or s[i+j] == c:
        #             res.append(j)
        #             found = True
        #             break
        #     if not found:
        #         res.append(n)
        # return res

        # 2nd solution: one pass
        # O(n) time | O(n) space
        # n = len(s)
        # res = [n] * n
        # pos = -n
        # for i in range(n):
        #     if s[i] == c:
        #         pos = i
        #     res[i] = min(res[i], abs(i - pos))
        # for i in range(n-1, -1, -1):
        #     if s[i] == c:
        #         pos = i
        #     res[i] = min(res[i], abs(i - pos))
        # return res

        # 3rd solution: two pointers
        # O(n) time | O(n) space
        n = len(s)
        res = [n] * n
        left = 0
        right = 0
        while right < n:
            while right < n and s[right] != c:
                right += 1
            for i in range(left, right):
                res[i] = min(res[i], abs(i - left))
            left = right
            while left < n and s[left] == c:
                left += 1
            for i in range(right, left):
                res[i] = min(res[i], abs(i - right))
            right = left
        return res