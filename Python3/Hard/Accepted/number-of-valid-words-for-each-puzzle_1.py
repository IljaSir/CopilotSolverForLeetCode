class Solution:
    def findNumOfValidWords(self, words: List[str], puzzles: List[str]) -> List[int]:
        
        dic = {}
        for word in words:
            mask = 0
            for c in set(word):
                mask |= 1 << (ord(c) - ord('a'))
            dic[mask] = dic.get(mask, 0) + 1
        res = []
        for puzzle in puzzles:
            total = 0
            mask = 0
            for i in range(1, 7):
                mask |= 1 << (ord(puzzle[i]) - ord('a'))
            subset = mask
            while subset:
                s = subset | 1 << (ord(puzzle[0]) - ord('a'))
                if s in dic:
                    total += dic[s]
                subset = (subset - 1) & mask
            if 1 << (ord(puzzle[0]) - ord('a')) in dic:
                total += dic[1 << (ord(puzzle[0]) - ord('a'))]
            res.append(total)
        return res