impl Solution {
    pub fn wonderful_substrings(word: String) -> i64 {
        
        let mut res = 0;
        let mut mask = 0;
        let mut map = [0; 1024];
        map[0] = 1;
        for c in word.chars() {
            mask ^= 1 << (c as u8 - b'a');
            res += map[mask] as i64;
            for i in 0..10 {
                res += map[mask ^ (1 << i)] as i64;
            }
            map[mask] += 1;
        }
        res
    }
}