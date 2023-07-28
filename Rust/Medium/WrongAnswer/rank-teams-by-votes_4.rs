impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut votes = votes;
        let mut map = std::collections::HashMap::new();
        for vote in votes.iter_mut() {
            vote.make_ascii_uppercase();
            for (i, c) in vote.chars().enumerate() {
                let e = map.entry(c).or_insert(vec![0; vote.len()]);
                e[i] += 1;
            }
        }
        let mut v = map.iter().collect::<Vec<_>>();
        v.sort_by(|&a, &b| {
            let a = a.1;
            let b = b.1;
            for i in 0..a.len() {
                if a[i] > b[i] {
                    return std::cmp::Ordering::Less;
                } else if a[i] < b[i] {
                    return std::cmp::Ordering::Greater;
                }
            }
            a[0].cmp(&b[0])
        });
        v.iter().map(|x| x.0).collect()
    }
}