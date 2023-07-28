class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        
        s = '123456789'
        res = []
        for i in range(len(s)):
            for j in range(i+1, len(s)):
                n = int(s[i:j+1])
                if n >= low and n <= high:
                    res.append(n)
        return sorted(res)