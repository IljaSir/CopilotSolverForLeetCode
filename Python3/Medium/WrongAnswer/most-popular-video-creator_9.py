class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        # create a dict with key = creator, value = {id, views}
        # iterate through dict and find max views
        # return the creator and id with max views
        creator_dict = {}
        for i in range(len(creators)):
            if creators[i] not in creator_dict:
                creator_dict[creators[i]] = {ids[i]: views[i]}
            else:
                creator_dict[creators[i]][ids[i]] = views[i]
        max_views = 0
        max_creator = []
        for creator in creator_dict:
            if sum(creator_dict[creator].values()) > max_views:
                max_views = sum(creator_dict[creator].values())
                max_creator = [creator, max(creator_dict[creator], key=creator_dict[creator].get)]
            elif sum(creator_dict[creator].values()) == max_views:
                if max(creator_dict[creator], key=creator_dict[creator].get) < max_creator[1]:
                    max_creator = [creator, max(creator_dict[creator], key=creator_dict[creator].get)]
        return max_creator