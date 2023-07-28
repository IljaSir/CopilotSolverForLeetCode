impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut i = 0;
        let mut n = intervals.len();
        while i < n && intervals[i][1] < new_interval[0] {
            res.push(intervals[i].clone());
            i += 1;
        }
        let mut merged = new_interval.clone();
        while i < n && intervals[i][0] <= new_interval[1] {
            merged[0] = merged[0].min(intervals[i][0]);
            merged[1] = merged[1].max(intervals[i][1]);
            i += 1;
        }
        res.push(merged);
        while i < n {
            res.push(intervals[i].clone());
            i += 1;
        }
        res
    }
}