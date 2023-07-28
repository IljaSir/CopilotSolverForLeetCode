class Solution:
    def originalDigits(self, s: str) -> str:
        
        count = collections.Counter(s)
        res = []
        for num in ['zero', 'two', 'four', 'six', 'eight', 'one', 'three', 'five', 'seven', 'nine']:
            while count[num[0]] > 0:
                res.append(str('zero', 'two', 'four', 'six', 'eight', 'one', 'three', 'five', 'seven', 'nine').index(num))
                for c in num:
                    count[c] -= 1
        return ''.join(sorted(map(str, res)))