impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut res = 0;
        let mut state = 0;
        let mut pos = vec![-1; 1 << 5];
        pos[0] = 0;
        for (i, c) in s.bytes().enumerate() {
            state ^= 1 << match c {
                b'a' => 0,
                b'e' => 1,
                b'i' => 2,
                b'o' => 3,
                b'u' => 4,
                _ => 5,
            };
            if pos[state] >= 0 {
                res = res.max(i as i32 + 1 - pos[state]);
            } else {
                pos[state] = i as i32 + 1;
            }
        }
        res
    }
}