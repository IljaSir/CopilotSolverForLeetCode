impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut result = Vec::new();
        for interval in intervals {
            if let Some(last) = result.last_mut() {
                if last[1] >= interval[0] {
                    last[1] = last[1].max(interval[1]);
                    continue;
                }
            }
            result.push(interval);
        }
        result
    }
}