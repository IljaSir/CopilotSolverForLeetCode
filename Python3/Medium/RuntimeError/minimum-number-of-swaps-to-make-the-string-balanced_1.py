class Solution:
    def minSwaps(self, s: str) -> int:
        
        # print(s)
        # print(s.count('['))
        # print(s.count(']'))
        # print(s.count('[') - s.count(']'))
        # print(s.count('[') - s.count(']')) % 2
        # print((s.count('[') - s.count(']')) % 2)
        if (s.count('[') - s.count(']')) % 2 != 0:
            return -1
        else:
            s = list(s)
            # print(s)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('[') - s.count(']')) % 2
            # print((s.count('[') - s.count(']')) % 2)
            # print(s)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('[') - s.count(']')) % 2
            # print((s.count('[') - s.count(']')) % 2)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('[') - s.count(']')) % 2
            # print((s.count('[') - s.count(']')) % 2)
            # print(s)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('[') - s.count(']')) % 2
            # print((s.count('[') - s.count(']')) % 2)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('[') - s.count(']')) % 2
            # print((s.count('[') - s.count(']')) % 2)
            # print(s)
            # print(s.count('['))
            # print(s.count(']'))
            # print(s.count('[') - s.count(']'))
            # print(s.count('['