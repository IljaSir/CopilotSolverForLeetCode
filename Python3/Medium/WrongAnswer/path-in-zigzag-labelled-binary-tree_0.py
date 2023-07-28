class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        
        # path = [label]
        # while label != 1:
        #     label //= 2
        #     path.append(label)
        # return path[::-1]
        path = []
        while label:
            path.append(label)
            label //= 2
        for i in range(len(path) - 1, -1, -2):
            path[i] = 3 * 2 ** (len(path) - 1 - i) - 1 - path[i]
        return path[::-1]