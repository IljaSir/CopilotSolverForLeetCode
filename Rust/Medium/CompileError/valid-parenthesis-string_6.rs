impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut stack = 
        let mut max = 0;
        for c in s.chars() {
            match c {
                '(' => {
                    min += 1;
                    max += 1;
                },
                ')' => {
                    min -= 1;
                    max -= 1;
                },
                '*' => {
                    min -= 1;
                    max += 1;
                },
                _ => (),
            }
            if max < 0 {
                return false;
            } {
                    return false;
                }
            } else {
                return false;
            }
        }
        true
    }
}