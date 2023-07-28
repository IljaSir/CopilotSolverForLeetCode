impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut i = 0;
        while i < intervals.len() - 1 {
            if intervals[i][1] >= intervals[i + 1][0] {
                intervals[i][1] = intervals[i][1].max(intervals[i + 1][1]);
                intervals.remove(i + 1);
            } else {
                i += 1;
            }
        }
        intervals
    }
}