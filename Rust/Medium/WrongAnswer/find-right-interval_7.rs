impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut intervals = intervals.iter().enumerate().collect::<Vec<_>>();
        intervals.sort_by_key(|&(_, v)| v[0]);
        let mut res = vec![-1; intervals.len()];
        for i in 0..intervals.len() {
            let mut l = i + 1;
            let mut r = intervals.len();
            while l < r {
                let m = l + (r - l) / 2;
                if intervals[m].1[0] < intervals[i].1[1] {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if l < intervals.len() {
                res[intervals[i].0] = intervals[l].0 as i32;
            }
        }
        res
    }
}