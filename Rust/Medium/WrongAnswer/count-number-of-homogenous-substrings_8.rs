impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut cnt = 1;
        let mut ans = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 1;
        while j < s.len() {
            if s[i] == s[j] {
                cnt += 1;
            } else {
                ans += (cnt * (cnt + 1)) / 2;
                cnt = 1;
                i = j;
            }
            j += 1;
        }
        ans += (cnt * (cnt + 1)) / 2;
        ans as i32 % 1000000007
    }
}