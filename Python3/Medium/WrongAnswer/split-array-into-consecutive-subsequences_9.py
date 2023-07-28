class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        # 1. count the frequency of each number
        # 2. 2-dimentional dict, key is the number, value is a dict with key is the length of subseq and value is the freq
        # 3. for each number, check if it can be added to the end of a subseq, if so, update the freq of the subseq, if not, check if it can start a new subseq, if so, update the freq of the new subseq, if not, return False
        # 4. return True
        freq = {}
        for n in nums:
            if n in freq:
                freq[n] += 1
            else:
                freq[n] = 1
        
        subseq = {}
        for n in nums:
            if n in subseq:
                if 1 in subseq[n]:
                    if subseq[n][1] == 1:
                        del subseq[n][1]
                    else:
                        subseq[n][1] -= 1
                    if 2 in subseq[n]:
                        subseq[n][2] += 1
                    else:
                        subseq[n][2] = 1
                elif 2 in subseq[n]:
                    if subseq[n][2] == 1:
                        del subseq[n][2]
                    else:
                        subseq[n][2] -= 1
                    if 3 in subseq[n]:
                        subseq[n][3] += 1
                    else:
                        subseq[n][3] = 1
                else:
                    if 3 in subseq[n]:
                        subseq[n][3] += 1
                    else:
                        subseq[n][3] = 1
                freq[n] -= 1
            else:
                if freq[n] == 0:
                    continue
                if n+1 in freq and freq[n+1] > 0:
                    if n+2 in freq and freq[n+2] > 0:
                        freq[n] -= 1
                        freq[n+1] -= 1
                        freq[n+2] -= 1
                        if n+2 in subseq:
                            if 1 in subseq[n+2]:
                                subseq[n+2][1] += 1
                            else:
                                subseq[n+2][1] = 1