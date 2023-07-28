impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut pos = vec![s.len(); 1 << 5];
        let mut ans = 0;
        let mut status = 0;
        pos[0] = 0;
        for (i, c) in s.as_bytes().iter().enumerate() {
            match *c {
                b'a' => status ^= 1 << 0,
                b'e' => status ^= 1 << 1,
                b'i' => status ^= 1 << 2,
                b'o' => status ^= 1 << 3,
                b'u' => status ^= 1 << 4,
                _ => (),
            }
            if pos[status] < s.len() {
                ans = ans.max(i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        ans as i32
    }
}