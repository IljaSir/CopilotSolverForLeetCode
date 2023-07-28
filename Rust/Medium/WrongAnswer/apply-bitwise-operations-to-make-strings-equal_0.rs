impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s0 = 0;
        let mut s1 = 0;
        let mut t0 = 0;
        let mut t1 = 0;
        for i in 0..s.len() {
            if s.chars().nth(i).unwrap() == '0' {
                s0 += 1;
            } else {
                s1 += 1;
            }
            if target.chars().nth(i).unwrap() == '0' {
                t0 += 1;
            } else {
                t1 += 1;
            }
        }
        s0 == t0 && s1 == t1
    }
}