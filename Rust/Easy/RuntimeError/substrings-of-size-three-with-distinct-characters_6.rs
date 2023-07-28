impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let mut count = 0;
        for i in 0..s.len() - 2 {
            let sub = &s[i..i + 3];
            if sub.chars().nth(0) != sub.chars().nth(1) &&
                sub.chars().nth(0) != sub.chars().nth(2) &&
                sub.chars().nth(1) != sub.chars().nth(2) {
                    count += 1;
                }
        }
        count
    }
}