impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let locked: Vec<char> = locked.chars().collect();
        let n = s.len();
        let mut l = 0;
        let mut r = 0;
        let mut l_locked = 0;
        let mut r_locked = 0;
        for i in 0..n {
            if s[i] == '(' {
                l += 1;
            } else {
                r += 1;
            }
            if locked[i] == '1' {
                if s[i] == '(' {
                    l_locked += 1;
                } else {
                    r_locked += 1;
                }
            }
            if r > l || l_locked > l || r_locked > r {
                return false;
            }
        }
        l = 0;
        r = 0;
        l_locked = 0;
        r_locked = 0;
        for i in (0..n).rev() {
            if s[i] == '(' {
                l += 1;
            } else {
                r += 1;
            }
            if locked[i] == '1' {
                if s[i] == '(' {
                    l_locked += 1;
                } else {
                    r_locked += 1;
                }
            }
            if r > l || l_locked > l || r_locked > r {
                return false;
            }
        }
        true
    }
}