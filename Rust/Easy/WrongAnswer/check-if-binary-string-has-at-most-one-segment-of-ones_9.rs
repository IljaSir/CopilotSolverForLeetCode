impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let mut flag = false;
        while j < s.len() {
            if s.chars().nth(j).unwrap() == '1' {
                flag = true;
                j += 1;
            } else {
                if flag {
                    i = j;
                    flag = false;
                }
                j += 1;
            }
        }
        i == 0
    }
}