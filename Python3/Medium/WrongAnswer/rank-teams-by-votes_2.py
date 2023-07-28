class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        
        # 1. Create a dict of team to list of rank
        # 2. Sort the dict by rank
        # 3. Return the team name
        team_to_rank = {}
        for vote in votes:
            for i, team in enumerate(vote):
                if team not in team_to_rank:
                    team_to_rank[team] = [0] * len(vote)
                team_to_rank[team][i] += 1
        return "".join(sorted(team_to_rank, key=lambda team: team_to_rank[team], reverse=True))