impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut s = start.chars().collect::<Vec<_>>();
        let mut t = target.chars().collect::<Vec<_>>();
        let mut diff = 0;
        for i in 0..s.len() {
            if s[i] == 'L' {
                diff -= 1;
            } else if s[i] == 'R' {
                diff += 1;
            }
            if t[i] == 'L' {
                diff += 1;
            } else if t[i] == 'R' {
                diff -= 1;
            }
            if diff < 0 {
                return false;
            }
        }
        diff == 0
    }
}