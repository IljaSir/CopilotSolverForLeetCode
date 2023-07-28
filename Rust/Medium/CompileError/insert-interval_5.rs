impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        let mut i = 0;
        while i < intervals.len() {
            if intervals[i][0] > new_interval[0] {
                break;
            }
            i += 1;
        }
        intervals.insert(i, new_interval);
        let mut result = vec![];
        for interval in intervals {
            if result.is_empty() || result[result.len()-1][1] < interval[0] {
                result.push(interval);
            } else {
                result[result.len()-1][1] = result[result.len()-1][1].max(interval[1]);
            }
        }
        result
    }
}