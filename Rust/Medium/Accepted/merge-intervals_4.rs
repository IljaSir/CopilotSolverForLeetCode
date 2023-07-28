impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut result = vec![];
        for interval in intervals {
            if result.is_empty() {
                result.push(interval);
                continue;
            }
            let last = result.last_mut().unwrap();
            if last[1] < interval[0] {
                result.push(interval);
            } else {
                last[1] = last[1].max(interval[1]);
            }
        }
        result
    }
}