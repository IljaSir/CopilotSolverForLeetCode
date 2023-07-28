class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        
        v1 = version1.split('.')
        v2 = version2.split('.')
        i = 0
        while i < len(v1) or i < len(v2):
            if i < len(v1):
                v1[i] = int(v1[i])
            else:
                v1.append(0)
            if i < len(v2):
                v2[i] = int(v2[i])
            else:
                v2.append(0)
            if v1[i] > v2[i]:
                return 1
            elif v1[i] < v2[i]:
                return -1
            i += 1
        return 0