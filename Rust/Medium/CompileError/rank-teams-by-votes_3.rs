impl Solution {
    pub fn rank_teams(votes: Vec<String>) -> String {
        
        let mut m = vec![vec![0; 26]; votes[0].len()];
        for vote in votes {
            for (i, c) in vote.bytes().enumerate() {
                m[i][c as usize - 'A' as usize] += 1;
            }
        }
        let mut v = vec![];
        for i in 0..26 {
            v.push((i, m[0][i]));
        }
        for i in 1..votes[0].len() {
            v.sort_by(|a, b| b.1.cmp(&a.1).then(a.0.cmp(&b.0)));
            for j in 0..26 {
                v[j].1 += m[i][v[j].0];
            }
        }
        v.sort_by(|a, b| b.1.cmp(&a.1).then(a.0.cmp(&b.0)));
        let mut r = String::new();
        for i in 0..26 {
            if v[i].1 > 0 {
                r.push((v[i].0 + 'A' as usize) as u8 as char);
            }
        }
        r
    }
}