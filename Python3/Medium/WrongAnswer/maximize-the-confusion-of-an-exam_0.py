class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        
        n = len(answerKey)
        t, f = 0, 0
        for i in range(n):
            if answerKey[i] == 'T':
                t += 1
            else:
                f += 1
        t -= k
        f -= k
        ans = 0
        for i in range(n):
            if t < 0:
                t += 1
            elif answerKey[i] == 'T':
                t += 1
            else:
                t -= 1
            if f < 0:
                f += 1
            elif answerKey[i] == 'F':
                f += 1
            else:
                f -= 1
            ans = max(ans, t, f)
        return ans