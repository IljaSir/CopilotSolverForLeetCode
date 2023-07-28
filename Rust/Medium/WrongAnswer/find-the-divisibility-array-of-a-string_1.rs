impl Solution {
    pub fn divisibility_array(word: String, m: i32) -> Vec<i32> {
        
        let mut res = vec![0; word.len()];
        let mut cur = 0;
        for (i, c) in word.bytes().enumerate() {
            cur = (cur * 10 + (c - b'0') as i32) % m;
            if cur == 0 {
                res[i] = 1;
            }
        }
        res
    }
}