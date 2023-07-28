impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut map = vec![-1; 1 << 5];
        let mut res = 0;
        let mut state = 0;
        map[0] = 0;
        for (i, c) in s.chars().enumerate() {
            if c == 'a' {
                state ^= 1 << 0;
            } else if c == 'e' {
                state ^= 1 << 1;
            } else if c == 'i' {
                state ^= 1 << 2;
            } else if c == 'o' {
                state ^= 1 << 3;
            } else if c == 'u' {
                state ^= 1 << 4;
            }
            if map[state] >= 0 {
                res = res.max(i as i32 + 1 - map[state]);
            } else {
                map[state] = i as i32 + 1;
            }
        }
        res
    }
}