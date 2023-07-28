impl Solution {
    pub fn erase_overlap_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        

        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut cur = std::i32::MIN;
        let mut ans = 0;
        for i in 0..intervals.len() {
            if intervals[i][0] >= cur {
                ans += 1;
                cur = intervals[i][1];
            }
        }
        (intervals.len() - ans) as i32
    }
}