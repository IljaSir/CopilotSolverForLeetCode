class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        
        # Solution 1 - 104 ms
        """
        if x > y:
            x, y = y, x
            s = s.replace("ab", "a").replace("ba", "b")
        else:
            s = s.replace("ba", "b").replace("ab", "a")
        return s.count("a") * x + s.count("b") * y
        """
        # Solution 2 - 104 ms
        # x = min(x, y)
        # y = max(x, y)
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 3 - 108 ms
        s = s.replace("ab", "a").replace("ba", "b")
        return s.count("a") * x + s.count("b") * y
        # Solution 4 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 5 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 6 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 7 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 8 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 9 - 108 ms
        # s = s.replace("ab", "a").replace("ba", "b")
        # return s.count("a") * x + s.count("b") * y
        # Solution 10 - 108 ms
        # s