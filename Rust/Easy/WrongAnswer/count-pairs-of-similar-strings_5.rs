impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..words.len() {
            for j in i+1..words.len() {
                let mut a = [0; 26];
                let mut b = [0; 26];
                for c in words[i].as_bytes() {
                    a[(c - b'a') as usize] += 1;
                }
                for c in words[j].as_bytes() {
                    b[(c - b'a') as usize] += 1;
                }
                if a == b {
                    cnt += 1;
                }
            }
        }
        cnt
    }
}