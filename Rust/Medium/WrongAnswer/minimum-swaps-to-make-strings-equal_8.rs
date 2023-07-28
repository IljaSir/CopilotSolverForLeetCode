impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut count = 0;
        let mut count_x = 0;
        let mut count_y = 0;
        for i in 0..s1.len() {
            if s1.as_bytes()[i] != s2.as_bytes()[i] {
                count += 1;
                if s1.as_bytes()[i] == 'x' as u8 {
                    count_x += 1;
                } else {
                    count_y += 1;
                }
            }
        }
        if count % 2 == 1 {
            return -1;
        }
        let mut result = 0;
        if count_x % 2 == 1 {
            result += 1;
        }
        if count_y % 2 == 1 {
            result += 1;
        }
        result
    }
}