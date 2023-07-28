impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let s = s.chars().collect::<Vec<char>>();
        let mut count = 0;
        for i in 0..s.len() {
            if i % 2 == 0 {
                if s[i] == '1' {
                    count += 1;
                }
            } else {
                if s[i] == '0' {
                    count += 1;
                }
            }
        }
        let mut count2 = 0;
        for i in 0..s.len() {
            if i % 2 == 0 {
                if s[i] == '0' {
                    count2 += 1;
                }
            } else {
                if s[i] == '1' {
                    count2 += 1;
                }
            }
        }
        count.min(count2)
    }
}