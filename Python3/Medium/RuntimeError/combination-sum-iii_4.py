class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        if k == 1:
            if n < 10:
                return [[n]]
            else:
                return []
        if k == 2:
            if n < 19:
                return [[i, n-i] for i in range(1, n//2+1)]
            else:
                return []
        if k == 3:
            if n < 28:
                return [[i, j, n-i-j] for i in range(1, n//3+1) for j in range(i+1, n//2+1) if n-i-j <= 9]
            else:
                return []
        if k == 4:
            if n < 37:
                return [[i, j, k, n-i-j-k] for i in range(1, n//4+1) for j in range(i+1, n//3+1) for k in range(j+1, n//2+1) if n-i-j-k <= 9]
            else:
                return []
        if k == 5:
            if n < 46:
                return [[i, j, k, l, n-i-j-k-l] for i in range(1, n//5+1) for j in range(i+1, n//4+1) for k in range(j+1, n//3+1) for l in range(k+1, n//2+1) if n-i-j-k-l <= 9]
            else:
                return []
        if k == 6:
            if n < 55:
                return [[i, j, k, l, m, n-i-j-k-l-m] for i in range(1, n//6+1) for j in range(i+1, n//5+1) for k in range(j+1, n//4+1) for l in range(k+1, n//3+1) for m in range(l+1, n//2+1) if n-i-j-k-l-m <= 9]
            else:
                return []
        if k == 7:
            if n < 64:
                return [[i, j, k, l, m, o, n-i-j-k-l-m-o] for i in range(1, n//7+1) for j in range(i+1, n//6+