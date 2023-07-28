impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut n = words.len();
        let mut v = Vec::new();
        for i in 0..n {
            let mut t = 0;
            for c in words[i].as_bytes() {
                t |= 1 << (c - b'a');
            }
            v.push(t);
        }
        let mut ans = 0;
        for i in 0..n {
            for j in i+1..n {
                if v[i] & v[j] == 0 {
                    ans = ans.max(words[i].len() * words[j].len());
                }
            }
        }
        ans as i32
    }
}