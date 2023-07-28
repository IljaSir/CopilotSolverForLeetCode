impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut start = intervals.iter().enumerate().map(|(i, v)| (v[0], i)).collect::<Vec<_>>();
        start.sort();
        let mut res = Vec::new();
        for i in 0..intervals.len() {
            let end = intervals[i][1];
            let mut l = 0;
            let mut r = start.len();
            while l < r {
                let mid = (l + r) / 2;
                if start[mid].0 >= end {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if l == start.len() {
                res.push(-1);
            } else {
                res.push(start[l].1 as i32);
            }
        }
        res
    }
}