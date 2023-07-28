class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        def is_fibonacci(a, b, c):
            return a + b == c

        def find_fibonacci(a, b, c):
            if c in fib:
                return fib[c]
            if is_fibonacci(a, b, c):
                fib[c] = find_fibonacci(b, c, c + b) + 1
            else:
                fib[c] = 0
            return fib[c]

        fib = {}
        for i in range(len(arr)):
            for j in range(i + 1, len(arr)):
                find_fibonacci(arr[i], arr[j], arr[i] + arr[j])
        return max(fib.values()) + 2 if fib else 0