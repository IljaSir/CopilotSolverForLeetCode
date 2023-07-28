class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        
        def helper(num, target, path, pos, value, prev):
            if pos == len(num):
                if value == target:
                    res.append(path)
                return
            for i in range(pos, len(num)):
                if i != pos and num[pos] == '0':
                    break
                curr = int(num[pos:i+1])
                if pos == 0:
                    helper(num, target, path+str(curr), i+1, curr, curr)
                else:
                    helper(num, target, path+'+'+str(curr), i+1, value+curr, curr)
                    helper(num, target, path+'-'+str(curr), i+1, value-curr, -curr)
                    helper(num, target, path+'*'+str(curr), i+1, value-prev+prev*curr, prev*curr)
        res = []
        helper(num, target, '', 0, 0, 0)
        return res