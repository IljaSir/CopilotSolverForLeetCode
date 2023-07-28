impl Solution {
    pub fn count_anagrams(s: String) -> i32 {
        
        let mut ans = 1;
        let mut last = ' ';
        let mut last_count = 0;
        for c in s.chars() {
            if c == ' ' {
                ans = ans * (last_count + 1) % 1_000_000_007;
                last_count = 0;
            } else {
                if c == last {
                    last_count += 1;
                } else {
                    last = c;
                    last_count = 1;
                }
            }
        }
        ans = ans * (last_count + 1) % 1_000_000_007;
        ans
    }
}