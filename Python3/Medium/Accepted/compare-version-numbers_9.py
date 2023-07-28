class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        
        def f(v):
            return [int(i) for i in v.split('.')]
        v1 = f(version1)
        v2 = f(version2)
        for i in range(max(len(v1), len(v2))):
            n1 = v1[i] if i < len(v1) else 0
            n2 = v2[i] if i < len(v2) else 0
            if n1 < n2:
                return -1
            elif n1 > n2:
                return 1
        return 0