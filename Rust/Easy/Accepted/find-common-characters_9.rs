impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut chs = vec![0; 26];
        let mut chs2 = vec![0; 26];
        let mut res = Vec::new();
        let mut first = true;
        for word in words {
            for ch in word.chars() {
                chs2[ch as usize - 'a' as usize] += 1;
            }
            if first {
                chs = chs2.clone();
                first = false;
            }
            for i in 0..26 {
                chs[i] = chs[i].min(chs2[i]);
            }
            chs2 = vec![0; 26];
        }
        for i in 0..26 {
            for _ in 0..chs[i] {
                res.push((i as u8 + 'a' as u8) as char);
            }
        }
        res.iter().map(|ch| ch.to_string()).collect()
    }
}