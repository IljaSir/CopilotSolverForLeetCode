impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut count = 0;
        let mut sum = 0;
        for c in s.chars() {
            match c {
                '(' => count += 1,
                ')' => {
                    if count > 0 {
                        count -= 1;
                    } else {
                        sum += 1;
                    }
                },
                _ => ()
            }
        }
        sum + count
    }
}