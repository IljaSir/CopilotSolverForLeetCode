class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def backtrack(a, b, num, fib):
            if not num:
                return True
            c = a + b
            if str(c) == num[:len(str(c))]:
                fib.append(c)
                return backtrack(b, c, num[len(str(c)):], fib)
            return False
        
        for i in range(1, len(num)):
            a = int(num[:i])
            if str(a) != num[:i]:
                break
            for j in range(i+1, len(num)):
                b = int(num[i:j])
                if str(b) != num[i:j]:
                    break
                fib = [a, b]
                if backtrack(a, b, num[j:], fib):
                    return fib
        return []