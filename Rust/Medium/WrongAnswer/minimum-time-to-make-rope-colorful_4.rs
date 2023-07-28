impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut last_c = ' ';
        let mut last_t = 0;
        for (c, t) in colors.chars().zip(needed_time) {
            if c == last_c {
                res += last_t.min(t);
            }
            last_c = c;
            last_t = t;
        }
        res
    }
}