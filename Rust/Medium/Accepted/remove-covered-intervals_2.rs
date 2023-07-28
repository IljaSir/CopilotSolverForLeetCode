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
        let mut res = 0;
        let mut right = 0;
        for interval in intervals {
            if right < interval[1] {
                res += 1;
                right = interval[1];
            }
        }
        res
    }
}