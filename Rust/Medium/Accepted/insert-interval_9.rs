impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        let mut new_interval = new_interval;
        let mut result = vec![];
        let mut i = 0;
        while i < intervals.len() {
            let interval = &intervals[i];
            if interval[1] < new_interval[0] {
                result.push(interval.to_vec());
            } else if interval[0] > new_interval[1] {
                result.push(new_interval.to_vec());
                new_interval = interval.to_vec();
            } else {
                new_interval[0] = std::cmp::min(new_interval[0], interval[0]);
                new_interval[1] = std::cmp::max(new_interval[1], interval[1]);
            }
            i += 1;
        }
        result.push(new_interval);
        result
    }
}