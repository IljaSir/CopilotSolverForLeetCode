impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut intervals = intervals;
        let mut res = vec![-1; intervals.len()];
        let mut left = vec![];
        for i in 0..intervals.len() {
            left.push((intervals[i][0], i));
        }
        left.sort_by(|a, b| a.0.cmp(&b.0));
        for i in 0..intervals.len() {
            let mut l = 0;
            let mut r = intervals.len();
            while l < r {
                let m = (l + r) / 2;
                if left[m].0 < intervals[i][1] {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if l < intervals.len() {
                res[i] = left[l].1 as i32;
            }
        }
        res
    }
}