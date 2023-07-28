impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut map = vec![vec![]; 26];
        for (i, c) in s.chars().enumerate() {
            map[(c as u8 - b'a') as usize].push(i);
        }
        for word in words {
            let mut prev = -1;
            let mut found = true;
            for c in word.chars() {
                let idx = (c as u8 - b'a') as usize;
                if let Ok(i) = map[idx].binary_search(&(prev + 1)) {
                    prev = map[idx][i];
                } else {
                    found = false;
                    break;
                }
            }
            if found {
                res += 1;
            }
        }
        res
    }
}