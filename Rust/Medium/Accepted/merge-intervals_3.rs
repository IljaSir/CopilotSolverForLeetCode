impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        if intervals.len() <= 1 {
            return intervals;
        }
        intervals.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut i = 1;
        while i < intervals.len() {
            if intervals[i][0] <= intervals[i - 1][1] {
                intervals[i - 1][0] = intervals[i - 1][0].min(intervals[i][0]);
                intervals[i - 1][1] = intervals[i - 1][1].max(intervals[i][1]);
                intervals.remove(i);
            } else {
                i += 1;
            }
        }
        intervals
    }
}