class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        #转置
        box = list(map(list, zip(*box)))
        #翻转
        for i in range(len(box)):
            box[i].reverse()
        
        #每一行处理
        for i in range(len(box)):
            #先把石头移动到最左边
            j = 0
            while j < len(box[i]):
                if box[i][j] == '#':
                    k = j
                    while k > 0 and box[i][k-1] == '.':
                        box[i][k-1] = '#'
                        box[i][k] = '.'
                        k -= 1
                j += 1
            #再把障碍物移动到石头后面
            j = 0
            while j < len(box[i]):
                if box[i][j] == '*':
                    k = j
                    while k < len(box[i]) - 1 and box[i][k+1] == '.':
                        box[i][k+1] = '*'
                        box[i][k] = '.'
                        k += 1
                j += 1
        #转置回来
        return list(map(list, zip(*box)))