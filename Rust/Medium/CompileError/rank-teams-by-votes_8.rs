impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut v = votes;
        let mut m = std::collections::HashMap::new();
        let mut r = String::new();
        let mut c = 0;
        for i in v[0].chars() {
            m.insert(i, std::collections::HashMap::new());
        }
        for i in 0..v[0].len() {
            for j in 0..v.len() {
                if let Some(e) = m.get_mut(&v[j].chars().nth(i).unwrap()) {
                    *e.entry(v[j].chars().nth(i).unwrap()).or_insert(0) += 1;
                }
            }
        }
        let mut n = m.into_iter().collect::<Vec<_>>();
        n.sort_by(|a, b| {
            let mut i = 0;
            for j in 0..a.1.len() {
                if *a.1.get(&a.0).unwrap() > *b.1.get(&a.0).unwrap() {
                    i = 1;
                    break;
                } else if *a.1.get(&a.0).unwrap() < *b.1.get(&a.0).unwrap() {
                    i = -1;
                    break;
                }
            }
            i
        });
        for i in n {
            r.push(i.0);
        }
        r
    }
}