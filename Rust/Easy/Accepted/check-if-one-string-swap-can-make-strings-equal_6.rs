impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let s1: Vec<char> = s1.chars().collect();
        let s2: Vec<char> = s2.chars().collect();
        let mut count = 0;
        let mut diff = Vec::new();
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                count += 1;
                diff.push((s1[i], s2[i]));
            }
        }
        if count == 0 {
            return true;
        }
        if count != 2 {
            return false;
        }
        diff[0].0 == diff[1].1 && diff[0].1 == diff[1].0
    }
}