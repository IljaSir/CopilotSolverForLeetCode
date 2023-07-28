class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        def match(stamp, target, i):
            for j in range(len(stamp)):
                if target[i+j] != '?' and stamp[j] != target[i+j]:
                    return False
            return True
        def replace(stamp, target, i):
            for j in range(len(stamp)):
                target[i+j] = stamp[j]
        n, m = len(stamp), len(target)
        target = list(target)
        ans = []
        changed = True
        while changed:
            changed = False
            for i in range(m-n+1):
                if match(stamp, target, i):
                    replace(stamp, target, i)
                    ans.append(i)
                    changed = True
        return ans[::-1] if all(x == '?' for x in target) else []