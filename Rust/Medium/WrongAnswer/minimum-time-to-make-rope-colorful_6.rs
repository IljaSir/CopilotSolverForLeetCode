impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut c = ' ';
        for (i, ch) in colors.chars().enumerate() {
            if ch != c {
                ans += needed_time[i];
            } else {
                ans += needed_time[i].min(ans);
            }
            c = ch;
        }
        ans
    }
}