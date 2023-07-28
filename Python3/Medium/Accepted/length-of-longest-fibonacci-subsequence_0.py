class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        s = set(arr)
        res = 0
        for i in range(len(arr)):
            for j in range(i+1, len(arr)):
                a, b = arr[i], arr[j]
                length = 2
                while a+b in s:
                    a, b = b, a+b
                    length += 1
                res = max(res, length)
        return res if res > 2 else 0