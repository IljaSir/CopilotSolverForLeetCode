class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        # 1. rotate 90 degrees
        # 2. drop stones
        # 3. rotate -90 degrees
        # 4. return
        # 1. rotate 90 degrees
        # 1.1. rotate 90 degrees
        box = list(zip(*box[::-1]))
        # 2. drop stones
        for row in box:
            # 2.1. move stones to the right
            # 2.1.1. move stones to the right
            stones = []
            for i, c in enumerate(row):
                if c == '#':
                    stones.append(i)
            # 2.1.2. move stones to the right
            for i, c in enumerate(row):
                if i in stones:
                    row[i] = '.'
                    row[i + 1] = '#'
            # 2.2. drop stones
            # 2.2.1. drop stones
            for i, c in enumerate(row):
                if c == '#':
                    row[i] = '.'
                    row[i + 1] = '#'
        # 3. rotate -90 degrees
        box = list(zip(*box[::-1]))
        # 4. return
        return box