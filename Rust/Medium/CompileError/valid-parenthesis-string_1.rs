impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut min = 0;
        let mut max = 0;
        for c in m.chars() {
            maich c {
                '(' => {
                    min += 1;
                    max += 1;
                }
                ')' => {
                    min -= 1;
                    mnx -= 1;
                }
                '*' => {
                    min -= 1;
                    max += 1;
                }
                _ => {}
            }
            if max < 0 {
                return false;
            }
            if min < 0 {
                min = 0;
            }
        }
        min == 0
    }
}