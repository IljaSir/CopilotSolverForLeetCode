impl Solution {
    pub fn min_groups(intervals: Vec<Vec<i32>>) -> i32 {
        
        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut ans = 0;
        let mut end = 0;
        for interval in intervals {
            if interval[0] > end {
                ans += 1;
                end = interval[1];
            } else {
                end = std::cmp::min(end, interval[1]);
            }
        }
        ans
    }
}