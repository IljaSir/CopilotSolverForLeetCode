class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        if len(b) == 0:
            return 1
        last = b.pop()
        part1 = self.superPow(a, b)
        part2 = self.myPow(a, last)
        return (part1 * part2) % 1337