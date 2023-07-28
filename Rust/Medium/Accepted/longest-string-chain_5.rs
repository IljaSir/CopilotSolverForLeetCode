impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words: Vec<Vec<char>> = words.iter().map(|s| s.chars().collect()).collect();
        words.sort_by_key(|w| w.len());
        let mut dp: Vec<i32> = vec![1; words.len()];
        for i in 1..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() == 1 {
                    if Self::is_predecessor(&words[j], &words[i]) {
                        dp[i] = dp[i].max(dp[j] + 1);
                    }
                }
            }
        }
        *dp.iter().max().unwrap()
    }
    fn is_predecessor(a: &Vec<char>, b: &Vec<char>) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a[i] == b[j] {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        i == a.len()
    }
}