class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        for i in range(len(strs),0,-1):
            for j in range(len(strs)):
                if len(strs[j]) != i:
                    continue
                flag = True
                for k in range(len(strs)):
                    if j == k:
                        continue
                    if self.check(strs[j],strs[k]):
                        flag = False
                        break
                if flag:
                    return i
        return -1