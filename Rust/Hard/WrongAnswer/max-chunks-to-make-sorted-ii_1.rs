impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in 0..arr.len() {
            if arr[i] > max {
                max = arr[i];
            }
            if max == i as i32 {
                count += 1;
            }
        }
        count
    }
}