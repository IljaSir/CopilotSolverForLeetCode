class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        
        # 1. Get the dict of team: [0, 0, 0, 0, 0, 0, 0]
        # 2. Fill the dict with votes
        # 3. Sort the dict by the values
        # 4. Return the keys
        team_to_votes = defaultdict(list)
        for vote in votes:
            for i, team in enumerate(vote):
                team_to_votes[team].append(i)
        sorted_teams = sorted(team_to_votes.items(), key=lambda x: (x[1], x[0]), reverse=True)
        return "".join([team for team, _ in sorted_teams])