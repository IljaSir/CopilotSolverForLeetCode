class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        n = len(seats)
        for i in range(n):
            if seats[i] == 1:
                break
        for j in range(n-1, -1, -1):
            if seats[j] == 1:
                break
        res = max(i, n-j-1)
        i = j = 0
        while i < n and j < n:
            while i < n and seats[i] == 0:
                i += 1
            j = i
            while j < n and seats[j] == 1:
                j += 1
            res = max(res, (j-i+1)//2)
            i = j
        return res