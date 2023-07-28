impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut ans = String::new();
        for i in 0..s.len() {
            for j in i..s.len() {
                let mut cnt = vec![0; 26];
                for c in s[i..=j].chars() {
                    cnt[c as usize - 'A' as usize] += 1;
                }
                let mut ok = true;
                for c in 0..26 {
                    if cnt[c] > 0 && cnt[c + 26] == 0 {
                        ok = false;
                        break;
                    }
                }
                if ok && j - i + 1 > ans.len() {
                    ans = s[i..=j].to_string();
                }
            }
        }
        ans
    }
}