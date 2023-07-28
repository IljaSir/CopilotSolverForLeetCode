class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def backtrack(fib, index):
            if index == len(num):
                return len(fib) >= 3
            curr = 0
            for i in range(index, len(num)):
                if i > index and num[index] == '0':
                    break
                curr = curr * 10 + int(num[i])
                if curr > 2 ** 31 - 1:
                    break
                if len(fib) >= 2 and curr > fib[-1] + fib[-2]:
                    break
                if len(fib) <= 1 or curr == fib[-1] + fib[-2]:
                    fib.append(curr)
                    if backtrack(fib, i + 1):
                        return True
                    fib.pop()
            return False
        fib = []
        backtrack(fib, 0)
        return fib