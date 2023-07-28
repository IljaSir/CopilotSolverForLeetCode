impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        for (i, n) in arr.iter().enumerate() {
            max = std::cmp::max(max, *n);
            if max == i as i32 {
                count += 1;
            }
        }
        count
    }
}