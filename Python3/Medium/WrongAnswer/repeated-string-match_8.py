class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if a in b:
            return 1
        # print(a)
        for i in range(len(b)):
            if a in b[i:]:
                return 1
        # print(a)
        for i in range(len(b)):
            if a in b[i:]:
                return 1
        # print(a)
        for i in range(len(b)):
            if a in b[i:]:
                return 1
        return -1