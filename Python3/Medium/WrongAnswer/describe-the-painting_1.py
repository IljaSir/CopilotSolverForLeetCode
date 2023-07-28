class Solution:
    def splitPainting(self, segments: List[List[int]]) -> List[List[int]]:
        
        # sort by start
        # for each segment, check if start == end of previous segment
        # if so, add color to previous segment
        # else add new segment
        segments = sorted(segments, key=lambda x: x[0])
        painting = []
        for segment in segments:
            if painting and segment[0] == painting[-1][1]:
                painting[-1][1] = segment[1]
                painting[-1][2] += segment[2]
            else:
                painting.append(segment)
        return painting