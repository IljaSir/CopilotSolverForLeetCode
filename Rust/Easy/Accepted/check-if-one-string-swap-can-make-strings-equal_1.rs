impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let mut diff = Vec::new();
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            if c1 != c2 {
                diff.push((c1, c2));
            }
        }
        if diff.len() == 0 {
            return true;
        }
        if diff.len() != 2 {
            return false;
        }
        diff[0].0 == diff[1].1 && diff[0].1 == diff[1].0
    }
}