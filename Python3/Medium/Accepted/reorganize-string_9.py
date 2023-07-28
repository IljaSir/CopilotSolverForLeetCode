class Solution:
    def reorganizeString(self, s: str) -> str:
        
        # use a heap to store the count of each character
        # pop 2 characters at a time, and if the character is the same, then return ""
        # otherwise, append the character to the result string
        # if there is only 1 character left, append it to the result string
        # if the length of the result string is not the same as the length of the input string, then return ""
        
        # create a dictionary to store the count of each character
        count = {}
        for c in s:
            count[c] = count.get(c, 0) + 1
        
        # create a heap to store the count of each character
        heap = []
        for c in count:
            heapq.heappush(heap, (-count[c], c))
        
        # create a result string
        result = ""
        
        # pop 2 characters at a time
        while len(heap) >= 2:
            # pop 2 characters
            count1, c1 = heapq.heappop(heap)
            count2, c2 = heapq.heappop(heap)
            
            # if the character is the same, then return ""
            if c1 == c2:
                return ""
            
            # otherwise, append the character to the result string
            result += c1
            result += c2
            
            # if the count of the character is not 0, push it back to the heap
            if count1 < -1:
                heapq.heappush(heap, (count1 + 1, c1))
            if count2 < -1:
                heapq.heappush(heap, (count2 + 1, c2))
        
        # if there is only 1 character left, append it to the result string
        if len(heap) > 0:
            result += heapq.heappop(heap)[1]
        
        # if the length of the result string is not the same as the length of the input string, then return ""
        if len(result) != len(s):
            return ""
        
        return result