impl Solution {
    pub fn longest_awesome(s: String) -> i32 {
        
        let mut seen = vec![-1; 1024];
        let mut mask = 0;
        let mut ans = 0;
        seen[0] = 0;
        for (i, c) in s.bytes().enumerate() {
            mask ^= 1 << (c - b'0');
            if seen[mask] >= 0 {
                ans = ans.max(i + 1 - seen[mask]);
            }
            for j in 0..10 {
                if seen[mask ^ (1 << j)] >= 0 {
                    ans = ans.max(i + 1 - seen[mask ^ (1 << j)]);
                }
            }
            if seen[mask] < 0 {
                seen[mask] = i + 1;
            }
        }
        ans as i32
    }
}