impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut result = 0;
        let mut state = 0;
        let mut seen = vec![0; 32];
        for (i, c) in s.chars().enumerate() {
            let mut mask = 0;
            match c {
                'a' => mask = 1,
                'e' => mask = 2,
                'i' => mask = 4,
                'o' => mask = 8,
                'u' => mask = 16,
                _ => (),
            }
            state ^= mask;
            if seen[state] == 0 {
                seen[state] = i as i32 + 1;
            }
            result = result.max(i as i32 + 1 - seen[state]);
        }
        result
    }
}