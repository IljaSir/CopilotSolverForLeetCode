impl Solution {
    pub fn find_right_interval(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut v = intervals.iter().enumerate().map(|(i, v)| (v[0], i)).collect::<Vec<_>>();
        v.sort();
        intervals.iter().map(|v| {
            match v[1].binary_search_by(|&i| v[0].cmp(&i)) {
                Ok(i) => v[1][i + 1],
                Err(i) => v[1][i],
            }
        }).collect()
    }
}