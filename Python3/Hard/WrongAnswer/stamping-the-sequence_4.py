class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        M, N = len(stamp), len(target)
        ans = []
        done = [False] * N
        def change(i, j, k):
            if all(done[j+k] or target[j+k] == stamp[k] for k in range(M)):
                for k in range(M):
                    done[j+k] = True
                ans.append(i)
                return True
            return False
        changed = True
        while changed:
            changed = False
            for i in range(N-M+1):
                if not done[i]:
                    changed |= change(i, i, 0)
            for i in range(N-M, -1, -1):
                if not done[i]:
                    changed |= change(i, i, 0)
        return ans[::-1] if all(done) else []