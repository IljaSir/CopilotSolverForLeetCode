impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = vec![];
        let mut i = 0;
        let mut new_interval = new_interval;
        while i < intervals.len() && intervals[i][1] < new_interval[0] {
            result.push(intervals[i].clone());
            i += 1;
        }
        while i < intervals.len() && intervals[i][0] <= new_interval[1] {
            new_interval = vec![new_interval[0].min(intervals[i][0]), new_interval[1].max(intervals[i][1])];
            i += 1;
        }
        result.push(new_interval);
        while i < intervals.len() {
            result.push(intervals[i].clone());
            i += 1;
        }
        result
    }
}