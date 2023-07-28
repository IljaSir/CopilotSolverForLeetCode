impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut m = vec![-1; 1 << 5];
        let mut ans = 0;
        let mut state = 0;
        m[0] = 0;
        for (i, c) in s.bytes().enumerate() {
            state ^= 1 << match c {
                b'a' => 0,
                b'e' => 1,
                b'i' => 2,
                b'o' => 3,
                b'u' => 4,
                _ => 5,
            };
            if m[state] >= 0 {
                ans = ans.max(i + 1 - m[state] as usize);
            } else {
                m[state] = i as i32 + 1;
            }
        }
        ans as i32
    }
}