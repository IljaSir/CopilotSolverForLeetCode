impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut teams = vec![vec![0; 26]; votes[0].len()];
        for vote in votes {
            for (i, c) in vote.chars().enumerate() {
                teams[i][c as usize - 'A' as usize] += 1;
            }
        }
        let mut result = votes[0].chars().collect::<Vec<char>>();
        result.sort_by(|a, b| {
            let (a, b) = (*a as usize - 'A' as usize, *b as usize - 'A' as usize);
            for i in 0..teams.len() {
                if teams[i][a] > teams[i][b] {
                    return std::cmp::Ordering::Less;
                } else if teams[i][a] < teams[i][b] {
                    return std::cmp::Ordering::Greater;
                }
            }
            std::cmp::Ordering::Equal
        });
        result.into_iter().collect()
    }
}