impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut ans = Vec::new();
        let mut cnt = [std::i32::MAX; 26];
        for word in words {
            let mut tmp = [0; 26];
            for c in word.chars() {
                tmp[(c as u8 - b'a') as usize] += 1;
            }
            for i in 0..26 {
                cnt[i] = cnt[i].min(tmp[i]);
            }
        }
        for i in 0..26 {
            for _ in 0..cnt[i] {
                ans.push((b'a' + i as u8) as char);
            }
        }
        ans.iter().map(|c| c.to_string()).collect()
    }
}