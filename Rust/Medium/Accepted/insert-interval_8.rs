impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        let mut new_interval = new_interval;
        let mut i = 0;
        while i < intervals.len() {
            if intervals[i][0] > new_interval[1] {
                intervals.insert(i, new_interval);
                return intervals;
            }
            if intervals[i][1] < new_interval[0] {
                i += 1;
                continue;
            }
            new_interval[0] = new_interval[0].min(intervals[i][0]);
            new_interval[1] = new_interval[1].max(intervals[i][1]);
            intervals.remove(i);
        }
        intervals.push(new_interval);
        intervals
    }
}