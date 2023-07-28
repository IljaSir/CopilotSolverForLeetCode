impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut intervals = intervals;
        let mut starts = vec![];
        for i in 0..intervals.len() {
            starts.push((intervals[i][0], i as i32));
        }
        starts.sort_by(|a, b| a.0.cmp(&b.0));
        let mut res = vec![];
        for i in 0..intervals.len() {
            let mut l = 0;
            let mut r = starts.len();
            while l < r {
                let mid = l + (r - l) / 2;
                if starts[mid].0 >= intervals[i][1] {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if l == starts.len() {
                res.push(-1);
            } else {
                res.push(starts[l].1);
            }
        }
        res
    }
}