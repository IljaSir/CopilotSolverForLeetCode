class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        ans = 0
        for i in range(n):
            if forts[i] == 1:
                l, r = i - 1, i + 1
                cnt = 0
                while l >= 0 and r < n:
                    if forts[l] == 0 and forts[r] == 0:
                        cnt += 2
                        l -= 1
                        r += 1
                    elif forts[l] == 0 and forts[r] == -1:
                        cnt += 1
                        l -= 1
                    elif forts[l] == -1 and forts[r] == 0:
                        cnt += 1
                        r += 1
                    else:
                        break
                ans = max(ans, cnt)
        return ans