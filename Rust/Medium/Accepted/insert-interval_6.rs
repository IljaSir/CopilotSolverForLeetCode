impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut intervals = intervals;
        let mut new_interval = new_interval;
        for i in 0..intervals.len() {
            if intervals[i][0] > new_interval[0] {
                intervals.insert(i, new_interval);
                return Self::merge(intervals);
            }
        }
        intervals.push(new_interval);
        Self::merge(intervals)
    }
    fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut ans = vec![];
        let mut i = 0;
        while i < intervals.len() {
            let mut j = i + 1;
            let mut end = intervals[i][1];
            while j < intervals.len() {
                if intervals[j][0] <= end {
                    end = end.max(intervals[j][1]);
                } else {
                    break;
                }
                j += 1;
            }
            ans.push(vec![intervals[i][0], end]);
            i = j;
        }
        ans
    }
}