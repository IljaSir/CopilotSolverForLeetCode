impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut s = s.chars().collect::<Vec<_>>();
        for i in (0..s.len()).rev() {
            if s[i] == s[s.len() - 1] {
                max += 1;
            } else {
                max = 0;
            }
            sum += max as i64;
        }
        sum
    }
}