impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut last = ' ';
        for (i, c) in colors.chars().enumerate() {
            if c == last {
                res += needed_time[i].min(needed_time[i - 1]);
            }
            last = c;
        }
        res
    }
}