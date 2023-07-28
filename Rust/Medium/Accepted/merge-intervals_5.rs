impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        intervals.sort_by_key(|v| v[0]);
        let mut result = vec![];
        let mut i = 0;
        while i < intervals.len() {
            let mut j = i + 1;
            let mut end = intervals[i][1];
            while j < intervals.len() && intervals[j][0] <= end {
                end = end.max(intervals[j][1]);
                j += 1;
            }
            result.push(vec![intervals[i][0], end]);
            i = j;
        }
        result
    }
}