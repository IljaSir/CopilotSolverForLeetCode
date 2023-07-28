class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        n, m = len(stamp), len(target)
        star = '*' * n
        target = list(target)
        ans = []
        def check(i):
            for j in range(n):
                if stamp[j] != target[i+j] and target[i+j] != '*':
                    return False
            return True
        
        def update(i):
            for j in range(n):
                target[i+j] = '*'
        
        while True:
            found = False
            for i in range(m-n+1):
                if check(i):
                    update(i)
                    found = True
                    ans.append(i)
            if not found:
                break
        if ''.join(target) != star:
            return []
        return ans[::-1]