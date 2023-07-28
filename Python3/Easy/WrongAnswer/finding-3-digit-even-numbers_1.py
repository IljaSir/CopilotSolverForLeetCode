class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        
        from itertools import permutations
        res = []
        for i in permutations(digits, 3):
            num = int(''.join(map(str, i)))
            if num % 2 == 0 and num not in res:
                res.append(num)
        return sorted(res)