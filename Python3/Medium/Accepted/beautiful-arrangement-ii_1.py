class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        answer = list(range(1, n - k))
        for i in range(k + 1):
            if i % 2 == 0:
                answer.append(n - k + i // 2)
            else:
                answer.append(n - i // 2)
        return answer