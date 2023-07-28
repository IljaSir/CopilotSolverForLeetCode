impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for vote in votes.iter() {
            for (i, c) in vote.chars().enumerate() {
                let e = map.entry(c).or_insert(vec![0; vote.len()]);
                e[i] += 1;
            }
        }
        let mut v = map.iter().map(|(k, v)| (*k, v)).collect::<Vec<_>>();
        v.sort_by(|a, b| {
            let mut i = 0;
            while i < a.1.len() {
                if a.1[i] > b.1[i] {
                    return std::cmp::Ordering::Less;
                } else if a.1[i] < b.1[i] {
                    return std::cmp::Ordering::Greater;
                }
                i += 1;
            }
            a.0.cmp(b.0)
        });
        v.iter().map(|(k, _)| *k).collect()
    }
}