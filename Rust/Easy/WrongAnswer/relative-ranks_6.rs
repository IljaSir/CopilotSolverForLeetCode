impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut v = score.clone();
        v.sort_by(|a, b| b.cmp(a));
        let mut r = vec![];
        for i in 0..score.len() {
            let mut s = String::new();
            let n = v.iter().position(|&x| x == score[i]).unwrap();
            match n {
                0 => s.push_str("Gold Medal"),
                1 => s.push_str("Silver Medal"),
                2 => s.push_str("Bronze Medal"),
                _ => s.push_str(&n.to_string()),
            }
            r.push(s);
        }
        r
    }
}