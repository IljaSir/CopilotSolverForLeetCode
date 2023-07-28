impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut max = arr[0];
        let mut max_ending_here = arr[0];
        let mut max_ending_here_dropped = arr[0];
        for i in 1..arr.len() {
            max_ending_here = std::cmp::max(max_ending_here + arr[i], arr[i]);
            max_ending_here_dropped = std::cmp::max(max_ending_here_dropped + arr[i], max_ending_here);
            max = std::cmp::max(max, std::cmp::max(max_ending_here, max_ending_here_dropped));
        }
        max
    }
}