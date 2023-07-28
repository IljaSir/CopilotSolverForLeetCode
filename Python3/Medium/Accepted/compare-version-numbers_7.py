class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        
        v1 = version1.split('.')
        v2 = version2.split('.')
        n = max(len(v1), len(v2))
        for i in range(n):
            if i < len(v1):
                x = int(v1[i])
            else:
                x = 0
            if i < len(v2):
                y = int(v2[i])
            else:
                y = 0
            if x > y:
                return 1
            elif x < y:
                return -1
        return 0