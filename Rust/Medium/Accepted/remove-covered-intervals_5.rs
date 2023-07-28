impl Solution {
    pub fn remove_covered_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        
        let mut intervals = intervals;
        intervals.sort_unstable_by(|a, b| a[0].cmp(&b[0]).then(b[1].cmp(&a[1])));
        let mut res = 0;
        let mut prev = 0;
        for i in 0..intervals.len() {
            if prev < intervals[i][1] {
                prev = intervals[i][1];
                res += 1;
            }
        }
        res
    }
}