impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut s = start.chars().collect::<Vec<char>>();
        let mut t = target.chars().collect::<Vec<char>>();
        let mut l = 0;
        let mut r = 0;
        for i in 0..s.len() {
            if s[i] == 'L' {
                l += 1;
            }
            if s[i] == 'R' {
                r += 1;
            }
            if t[i] == 'L' {
                l -= 1;
            }
            if t[i] == 'R' {
                r -= 1;
            }
        }
        l == 0 && r == 0
    }
}