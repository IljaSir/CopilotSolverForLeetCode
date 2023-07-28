impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            return true;
        }
        let mut diff = Vec::new();
        for (i, c) in s1.chars().enumerate() {
            if c != s2.chars().nth(i).unwrap() {
                diff.push(i);
            }
        }
        if diff.len() == 2 {
            let i = diff[0];
            let j = diff[1];
            if s1.chars().nth(i).unwrap() == s2.chars().nth(j).unwrap() && s1.chars().nth(j).unwrap() == s2.chars().nth(i).unwrap() {
                return true;
            }
        }
        false
    }
}