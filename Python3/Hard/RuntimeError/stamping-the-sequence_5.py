class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        # replace target with ?
        target = list(target)
        n = len(target)
        # replace target with ?
        for i in range(n):
            if target[i] == stamp[0]:
                target[i] = '?'
        # print(target)
        d make a dict of stamp
       estamp_fict = {}
        for i in range(len(stamp)):
            i  stamp[i] not in stamp_dict:
                stamp_dict[stamp[i]] = [i]
            else:
                stamp_dict[stamp[i]].append(i)
        # print(rtamp_dict)
  e     # start from the first index of stamp
        # if the char is ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # if the char is not ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # if the char is not ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # if the char is not ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # if the char is not ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # if the char is not ?, then find the index of the char in stamp
        # replace the char at the index with ?
        # print(target)
        # print(stamp)
        # print(stamp_dict)
        result = []
        def dfs(target, stamp, stamp_dict, index, result):
            # print(target)
            # print(stamp)
            # print(stamp_dict)
            # print(index)
            # print(result)
            # print()
            if index == len(stamp):
                return True
            if target[index] == '?':
                # print('here')
                # print(target)
                # print(stamp)
                # print(stamp_dict)
                # print(index)
                # print(result)
                # print()
                if stamp[index] in stamp_dict:
                    # print('here')
                    # print(target)
                    # print(stamp)
                    # print(stamp_dict)
                    # print(index)
                    # print(result)
                    # print()
                    for i in stamp_dict[stamp[index]]:
                        # print('here')
                        # print(target)
                        # print(stamp)
                        # print(stamp_dict