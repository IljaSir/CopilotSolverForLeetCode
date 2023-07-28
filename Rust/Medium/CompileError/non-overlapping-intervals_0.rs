impl Solution {
    pub fn erase_overlap_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        

        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut count = 0;
        let mut end = std::i32::MIN;
        for interval in intervals {
            if interval[0] >= end {
                count += 1;
                end = interval[1];
            }
        }
        (intervals.len() - count) as i32
    }
}