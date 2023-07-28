class Solution:
    def splitNum(self, num: int) -> int:
        
        num = str(num)
        n = len(num)
        count = [0] * 10
        for i in range(n):
            count[int(num[i])] += 1
        answer = 0
        for i in range(1, 10):
            if count[i] == 0:
                continue
            count[i] -= 1
            for j in range(10):
                if count[j] > 0:
                    count[j] -= 1
                    answer += i * 10 + j
                    break
            break
        for i in range(1, 10):
            while count[i] > 0:
                answer += i
                count[i] -= 1
        return answer