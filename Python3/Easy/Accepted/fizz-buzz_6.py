class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        
        # Solution 1 - 28 ms
        """
        ans = []
        for i in range(1, n+1):
            if i % 15 == 0:
                ans.append("FizzBuzz")
            elif i % 3 == 0:
                ans.append("Fizz")
            elif i % 5 == 0:
                ans.append("Buzz")
            else:
                ans.append(str(i))
        return ans
        """
        # Solution 2 - 24 ms
        return ["Fizz"*(not i % 3) + "Buzz"*(not i % 5) or str(i) for i in range(1, n+1)]