impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut res = vec![];
        let mut starts = vec![];
        for (i, interval) in intervals.iter().enumerate() {
            starts.push((interval[0], i));
        }
        starts.sort_by(|a, b| a.0.cmp(&b.0));
        for interval in intervals {
            let mut l = 0;
            let mut r = starts.len();
            let mut ans = -1;
            while l < r {
                let m = l + (r - l) / 2;
                if starts[m].0 >= interval[1] {
                    ans = starts[m].1 as i32;
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            res.push(ans);
        }
        res
    }
}