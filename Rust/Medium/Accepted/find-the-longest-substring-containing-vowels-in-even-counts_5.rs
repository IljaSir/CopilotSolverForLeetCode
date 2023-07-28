impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut res = 0;
        let mut seen = vec![-1; 32];
        let mut mask = 0;
        seen[0] = 0;
        for (i, c) in s.chars().enumerate() {
            mask ^= match c {
                'a' => 1,
                'e' => 2,
                'i' => 4,
                'o' => 8,
                'u' => 16,
                _ => 0,
            };
            if seen[mask] >= 0 {
                res = res.max(i as i32 + 1 - seen[mask]);
            } else {
                seen[mask] = i as i32 + 1;
            }
        }
        res
    }
}