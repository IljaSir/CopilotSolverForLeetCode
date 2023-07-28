impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        let mut min = vec![std::i32::MAX; 26];
        for word in words {
            let mut count = vec![0; 26];
            for c in word.chars() {
                count[(c as u8 - 'a' as u8) as usize] += 1;
            }
            for i in 0..26 {
                min[i] = min[i].min(count[i]);
            }
        }
        for i in 0..26 {
            for _ in 0..min[i] {
                res.push((i as u8 + 'a' as u8) as char);
            }
        }
        res.iter().map(|x| x.to_string()).collect()
    }
}