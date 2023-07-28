class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        def match(i):
            for j in range(len(stamp)):
                if target[i+j] == '?':
                    continue
                if target[i+j] != stamp[j]:
                    return False
            return True
        
        def replace(i):
            for j in range(len(stamp)):
                target[i+j] = '?'
        
        target = list(target)
        ans = []
        while True:
            found = False
            for i in range(len(target)-len(stamp)+1):
                if match(i):
                    replace(i)
                    ans.append(i)
                    found = True
            if not found:
                break
        return ans[::-1] if all(x == '?' for x in target) else []