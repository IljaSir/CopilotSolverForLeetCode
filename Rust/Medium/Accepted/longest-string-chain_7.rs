impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words = words.iter().map(|x| x.as_bytes()).collect::<Vec<&[u8]>>();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut dp = vec![1; words.len()];
        let mut ans = 0;
        for i in 0..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() == 1 && Self::is_predecessor(words[j], words[i]) {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            ans = ans.max(dp[i]);
        }
        ans
    }
    fn is_predecessor(pre: &[u8], cur: &[u8]) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < pre.len() {
            if pre[i] != cur[j] {
                if i != j {
                    return false;
                }
                j += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        true
    }
}