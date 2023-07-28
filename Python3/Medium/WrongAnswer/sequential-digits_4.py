class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        
        ans = []
        for i in range(1, 10):
            num = i
            while num <= high:
                if low <= num:
                    ans.append(num)
                num = num * 10 + (num % 10 + 1)
        return sorted(ans)