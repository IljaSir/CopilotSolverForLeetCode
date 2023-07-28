impl Solution {
    pub fn minimum_abs_difference(arr: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut arr = arr;
        arr.sort();
        let mut min_diff = i32::max_value();
        let mut res = vec![];
        for i in 0..arr.len() - 1 {
            let diff = arr[i + 1] - arr[i];
            if diff < min_diff {
                min_diff = diff;
                res.clear();
                res.push(vec![arr[i], arr[i + 1]]);
            } else if diff == min_diff {
                res.push(vec![arr[i], arr[i + 1]]);
            }
        }
        res
    }
}