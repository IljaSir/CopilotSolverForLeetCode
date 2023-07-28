class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def backtrack(first, second, num, path):
            if not num:
                return True
            if first == 2**31-1 or second == 2**31-1:
                return False
            for i in range(1, len(num)+1):
                if num[:i] == '0' or (num[0] != '0' and int(num[:i]) < 2**31-1):
                    third = int(num[:i])
                    if third == first + second:
                        path.append(third)
                        if backtrack(second, third, num[i:], path):
                            return True
                        path.pop()
            return False
        return backtrack(0, 0, num, [])