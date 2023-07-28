impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut rank = vec![vec![0; 26]; votes[0].len()];
        for vote in votes {
            for (i, c) in vote.chars().enumerate() {
                rank[i][c as usize - 'A' as usize] += 1;
            }
        }
        let mut teams: Vec<char> = votes[0].chars().collect();
        teams.sort_by(|&a, &b| {
            for i in 0..rank.len() {
                if rank[i][a as usize - 'A' as usize] != rank[i][b as usize - 'A' as usize] {
                    return rank[i][b as usize - 'A' as usize].cmp(&rank[i][a as usize - 'A' as usize]);
                }
            }
            a.cmp(&b)
        });
        teams.iter().collect()
    }
}