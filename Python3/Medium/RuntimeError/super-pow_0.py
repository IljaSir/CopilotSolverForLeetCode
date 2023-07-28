class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        if not b:
            return 1
        last = b.pop()
        part1 = self.myPow(a, last)
        part2 = self.myPow(self.superPow(a, b), 10)
        return (part1 * part2) % 1337