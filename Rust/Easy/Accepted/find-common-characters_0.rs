impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut arr = vec![0; 26];
        for c in words[0].as_bytes() {
            arr[(c - b'a') as usize] += 1;
        }
        for word in &words[1..] {
            let mut tmp = vec![0; 26];
            for c in word.as_bytes() {
                tmp[(c - b'a') as usize] += 1;
            }
            for i in 0..26 {
                arr[i] = arr[i].min(tmp[i]);
            }
        }
        let mut res = vec![];
        for i in 0..26 {
            for _ in 0..arr[i] {
                res.push((b'a' + i as u8) as char);
            }
        }
        res.into_iter().map(|x| x.to_string()).collect()
    }
}