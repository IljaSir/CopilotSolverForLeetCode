impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut starts = vec![];
        for (i, interval) in intervals.iter().enumerate() {
            starts.push((interval[0], i as i32));
        }
        starts.sort_by_key(|x| x.0);
        let mut res = vec![];
        for interval in intervals {
            let mut left = 0;
            let mut right = starts.len();
            while left < right {
                let mid = left + (right - left) / 2;
                if starts[mid].0 < interval[1] {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if left >= starts.len() {
                res.push(-1);
            } else {
                res.push(starts[left].1);
            }
        }
        res
    }
}