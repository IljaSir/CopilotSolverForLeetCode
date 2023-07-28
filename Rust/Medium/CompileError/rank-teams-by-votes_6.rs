impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        if votes.len() == 1 {
            return votes[0].clone();
        }
        let mut votes: Vec<Vec<char>> = votes.iter().map(|x| x.chars().collect()).collect();
        let mut m: HashMap<char, Vec<usize>> = HashMap::new();
        for i in 0..votes[0].len() {
            for j in 0..votes.len() {
                let c = votes[j][i];
                let v = m.entry(c).or_insert(vec![0; votes[0].len()]);
                v[i] += 1;
            }
        }
        let mut v: Vec<(char, Vec<usize>)> = m.into_iter().collect();
        v.sort_by(|a, b| {
            for i in 0..a.1.len() {
                if a.1[i] > b.1[i] {
                    return std::cmp::Ordering::Less;
                } else if a.1[i] < b.1[i] {
                    return std::cmp::Ordering::Greater;
                }
            }
            a.0.cmp(&b.0)
        });
        v.iter().map(|x| x.0).collect()
    }
}