impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut ans = Vec::new();
        let mut i = 0;
        while i < intervals.len() && intervals[i][1] < new_interval[0] {
            ans.push(intervals[i].clone());
            i += 1;
        }
        let mut new_start = new_interval[0];
        let mut new_end = new_interval[1];
        while i < intervals.len() && intervals[i][0] <= new_interval[1] {
            new_start = new_start.min(intervals[i][0]);
            new_end = new_end.max(intervals[i][1]);
            i += 1;
        }
        ans.push(vec![new_start, new_end]);
        while i < intervals.len() {
            ans.push(intervals[i].clone());
            i += 1;
        }
        ans
    }
}