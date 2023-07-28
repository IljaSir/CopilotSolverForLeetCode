impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let locked = locked.chars().collect::<Vec<char>>();
        let mut diff = 0;
        for i in 0..s.len() {
            if locked[i] == '1' {
                continue;
            }
            if s[i] == '(' {
                diff += 1;
            } else {
                diff -= 1;
            }
            if diff < 0 {
                s[i] = '(';
                diff += 1;
            }
        }
        let mut diff = 0;
        for i in (0..s.len()).rev() {
            if locked[i] == '1' {
                continue;
            }
            if s[i] == '(' {
                diff += 1;
            } else {
                diff -= 1;
            }
            if diff < 0 {
                s[i] = ')';
                diff += 1;
            }
        }
        diff == 0
    }
}