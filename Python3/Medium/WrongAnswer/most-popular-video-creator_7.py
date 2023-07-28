class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        creatorToViews = {}
        creatorToId = {}
        for i, creator in enumerate(creators):
            if creator not in creatorToViews:
                creatorToViews[creator] = 0
                creatorToId[creator] = ids[i]
            creatorToViews[creator] += views[i]
            if creatorToViews[creator] < views[i]:
                creatorToViews[creator] = views[i]
                creatorToId[creator] = ids[i]
        maxViews = max(creatorToViews.values())
        return [[creator, creatorToId[creator]] for creator in creatorToViews if creatorToViews[creator] == maxViews]