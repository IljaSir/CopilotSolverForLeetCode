impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut c1 = 0;
        let mut c2 = 0;
        for i in 0..s.len() {
            if i % 2 == 0 {
                if s[i] == '0' { c1 += 1; }
                else { c2 += 1; }
            } else {
                if s[i] == '0' { c2 += 1; }
                else { c1 += 1; }
            }
        }
        if c1 == c2 { return c1.min(c2); }
        -1
    }
}