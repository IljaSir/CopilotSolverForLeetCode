class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def backtrack(idx):
            if idx == n:
                return len(fib) >= 3
            curr = 0
            for i in range(idx, n):
                if i > idx and num[idx] == '0':
                    break
                curr = curr * 10 + ord(num[i]) - ord('0')
                if curr > 2**31 - 1:
                    break
                if len(fib) >= 2:
                    if curr < fib[-1] + fib[-2]:
                        continue
                    elif curr > fib[-1] + fib[-2]:
                        break
                fib.append(curr)
                if backtrack(i + 1):
                    return True
                fib.pop()
            return False
        n = len(num)
        fib = []
        backtrack(0)
        return fib