impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut min = [100; 26];
        for word in words {
            let mut count = [0; 26];
            for c in word.chars() {
                count[c as usize - 'a' as usize] += 1;
            }
            for i in 0..26 {
                min[i] = min[i].min(count[i]);
            }
        }
        for i in 0..26 {
            for _ in 0..min[i] {
                res.push((i + 'a' as usize) as u8 as char);
            }
        }
        res.iter().map(|c| c.to_string()).collect()
    }
}