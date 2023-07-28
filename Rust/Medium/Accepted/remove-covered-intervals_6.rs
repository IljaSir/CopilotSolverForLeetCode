impl Solution {
    pub fn remove_covered_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        
        let mut intervals = intervals;
        intervals.sort_by_key(|x| (x[0], -x[1]));
        let mut count = 1;
        let mut prev = &intervals[0];
        for i in 1..intervals.len() {
            if intervals[i][1] > prev[1] {
                count += 1;
                prev = &intervals[i];
            }
        }
        count
    }
}