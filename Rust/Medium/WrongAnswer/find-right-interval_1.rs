impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut result = vec![-1; intervals.len()];
        let mut intervals: Vec<(i32, i32, usize)> = intervals.into_iter().enumerate().map(|(i, v)| (v[0], v[1], i)).collect();
        intervals.sort_by(|a, b| a.0.cmp(&b.0));
        for i in 0..intervals.len() {
            let mut left = i + 1;
            let mut right = intervals.len() - 1;
            while left <= right {
                let mid = (left + right) / 2;
                if intervals[mid].0 >= intervals[i].1 {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if left < intervals.len() {
                result[intervals[i].2] = intervals[left].2 as i32;
            }
        }
        result
    }
}