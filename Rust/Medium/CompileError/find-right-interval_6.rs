impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut result = vec![-1; intervals.len()];
        let mut intervals: Vec<(usize, Vec<i32>)> = intervals.into_iter().enumerate().collect();
        intervals.sort_by_key(|(_, v)| v[0]);
        for (i, v) in intervals.iter().enumerate() {
            if let Ok(j) = intervals.binary_search_by_key(&v[1], |(_, v)| v[0]) {
                result[v.0] = intervals[j].0 as i32;
            } else if j < intervals.len() {
                result[v.0] = intervals[j].0 as i32;
            }
        }
        result
    }
}