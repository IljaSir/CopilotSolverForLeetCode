impl Solution {
    pub fn count_anagrams(s: String) -> i32 {
        
        let mut ans = 0;
        let mut cnt = 0;
        let mut last = ' ';
        for c in s.chars() {
            if c == ' ' {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            } else {
                if c == last {
                    cnt += 1;
                } else {
                    ans += cnt * (cnt + 1) / 2;
                    cnt = 1;
                    last = c;
                }
            }
        }
        ans += cnt * (cnt + 1) / 2;
        ans as i32
    }
}