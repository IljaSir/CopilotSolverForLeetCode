impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        let mut merged = Vec::new();
        intervals.sort_by_key(|x| x[0]);
        for interval in intervals {
            if merged.is_empty() || merged.last().unwrap()[1] < interval[0] {
                merged.push(interval);
            } else {
                let last = merged.pop().unwrap();
                merged.push(vec![last[0], interval[1].max(last[1])]);
            }
        }
        merged
    }
}