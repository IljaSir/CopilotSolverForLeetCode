impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        
        let mut maxs = vec![0; arr.len()];
        let mut mins = vec![0; arr.len()];
        let mut max = 0;
        let mut min = 0;
        for i in 0..arr.len() {
            max = std::cmp::max(max, arr[i]);
            maxs[i] = max;
        }
        for i in (0..arr.len()).rev() {
            min = std::cmp::min(min, arr[i]);
            mins[i] = min;
        }
        let mut ret = 0;
        for i in 0..arr.len() {
            if maxs[i] <= mins[i+1] {
                ret += 1;
            }
        }
        ret
    }
}