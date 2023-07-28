impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        let mut in_pair = false;
        for ch in s.chars() {
            match ch {
                '*' => {
                    if !in_pair {
                        count += 1;
                    }
                }
                '|' => {
                    in_pair = !in_pair;
                }
                _ => {}
            }
        }
        count
    }
}