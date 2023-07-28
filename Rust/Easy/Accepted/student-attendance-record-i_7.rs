impl Solution {
    pub fn check_record(s: String) -> bool {
        
        let mut num_a = 0;
        let mut num_l = 0;
        for c in s.chars() {
            match c {
                'A' => {
                    num_a += 1;
                    if num_a > 1 {
                        return false;
                    }
                    num_l = 0;
                }
                'L' => {
                    num_l += 1;
                    if num_l > 2 {
                        return false;
                    }
                }
                _ => num_l = 0,
            }
        }
        true
    }
}