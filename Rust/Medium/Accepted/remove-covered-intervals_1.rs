impl Solution {
    pub fn remove_covered_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        
        let mut intervals = intervals;
        intervals.sort_by(|a, b| {
            if a[0] == b[0] {
                b[1].cmp(&a[1])
            } else {
                a[0].cmp(&b[0])
            }
        });
        let mut ans = 0;
        let mut max = 0;
        for interval in intervals {
            if interval[1] > max {
                ans += 1;
                max = interval[1];
            }
        }
        ans
    }
}