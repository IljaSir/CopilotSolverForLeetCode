impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let mut count = 0;
        let s = s.chars().collect::<Vec<char>>();
        let n = s.len();
        for i in 0..n {
            count += 1;
            for j in 1..=(n - i).min(i + 1) {
                if s[i - j + 1] != s[i + j - 1] {
                    break;
                }
                count += 1;
            }
            for j in 0..=(n - i).min(i) {
                if s[i - j] != s[i + j] {
                    break;
                }
                count += 1;
            }
        }
        count - n as i32
    }
}