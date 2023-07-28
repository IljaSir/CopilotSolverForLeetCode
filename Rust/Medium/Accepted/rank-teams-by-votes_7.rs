impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut v = votes;
        let mut m = std::collections::HashMap::new();
        let mut l = v[0].len();
        for s in v {
            for (i, c) in s.chars().enumerate() {
                let e = m.entry(c).or_insert(vec![0; l]);
                e[i] += 1;
            }
        }
        let mut v = m.into_iter().collect::<Vec<(char, Vec<i32>)>>();
        v.sort_by(|a, b| {
            for i in 0..l {
                if a.1[i] != b.1[i] {
                    return a.1[i].cmp(&b.1[i]).reverse();
                }
            }
            a.0.cmp(&b.0)
        });
        v.iter().map(|x| x.0).collect()
    }
}