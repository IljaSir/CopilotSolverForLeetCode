class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        
        folder = sorted(folder)
        ans = []
        for i in range(len(folder)):
            if i == 0:
                ans.append(folder[i])
            elif not folder[i].startswith(ans[-1] + '/'):
                ans.append(folder[i])
        return ans