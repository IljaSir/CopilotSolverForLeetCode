impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut vote_map: HashMap<char, Vec<usize>> = HashMap::new();
        let mut team_set: HashSet<char> = HashSet::new();
        for v in votes.iter() {
            for (i, c) in v.chars().enumerate() {
                team_set.insert(c);
                if !vote_map.contains_key(&c) {
                    vote_map.insert(c, vec![0; v.len()]);
                }
                let mut v = vote_map.get_mut(&c).unwrap();
                v[i] += 1;
            }
        }
        let mut team_vec: Vec<char> = team_set.into_iter().collect();
        team_vec.sort_by(|a, b| {
            let mut a = vote_map.get(&a).unwrap();
            let mut b = vote_map.get(&b).unwrap();
            for i in 0..a.len() {
                if a[i] > b[i] {
                    return std::cmp::Ordering::Less;
                } else if a[i] < b[i] {
                    return std::cmp::Ordering::Greater;
                }
            }
            a[0].cmp(&b[0])
        });
        team_vec.iter().collect()
    }
}