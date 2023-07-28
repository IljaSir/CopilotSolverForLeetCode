class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        arr = [[] for i in range(numRows)]
        i = 0
        while i < len(s):
            for j in range(numRows):
                if i < len(s):
                    arr[j].append(s[i])
                    i += 1
                else:
                    break
            for j in range(numRows - 2, 0, -1):
                if i < len(s):
                    arr[j].append(s[i])
                    i += 1
                else:
                    break
        return ''.join([''.join(arr[i]) for i in range(numRows)])