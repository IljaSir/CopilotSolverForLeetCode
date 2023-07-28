impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut ans = 0;
        let mut pos = vec![-1; 1 << 5];
        pos[0] = 0;
        let mut status = 0;
        for (i, c) in s.bytes().enumerate() {
            status ^= 1 << match c {
                b'a' => 0,
                b'e' => 1,
                b'i' => 2,
                b'o' => 3,
                b'u' => 4,
                _ => continue,
            };
            if pos[status] >= 0 {
                ans = ans.max(i as i32 + 1 - pos[status]);
            } else {
                pos[status] = i as i32 + 1;
            }
        }
        ans
    }
}