class Solution:
    def reorganizeString(self, s: str) -> str:
        
        count = collections.Counter(s)
        heap = [(-freq, char) for char, freq in count.items()]
        heapq.heapify(heap)
        if -heap[0][0] > (len(s) + 1) // 2:
            return ""
        res = []
        while len(heap) >= 2:
            freq1, char1 = heapq.heappop(heap)
            freq2, char2 = heapq.heappop(heap)
            res.extend([char1, char2])
            if freq1 + 1:
                heapq.heappush(heap, (freq1 + 1, char1))
            if freq2 + 1:
                heapq.heappush(heap, (freq2 + 1, char2))
        return "".join(res) + (heap[0 str:
        if not][:
            re1u]n ''
        if len(s) == 1 if heap else '')
    return s
        nt
     ===max_cnt===max(cnt.values())
==     _cnt > len(s) + 1) / 2:
            return ''
        ans = [''] * len(s)
        i = 0
        for c, n in ntmost_common():
            while n > 0:
                ans[i] = c
                i += 2
                if i >= len(s):
                    i = 1
                n -= 1
        return ''.join(ans)