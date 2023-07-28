class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        
        return [str(i) if i % 3 != 0 and i % 5 != 0 else "Fizz" * (i % 3 == 0) + "Buzz" * (i % 5 == 0) for i in range(1, n + 1)]