impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut chars = s.chars().rev();
        while let Some(c) = chars.next() {
            if c == chars.clone().next().unwrap_or(' ') {
                max += 1;
            } else {
                max = 0;
            }
            sum += max;
        }
        sum
    }
}