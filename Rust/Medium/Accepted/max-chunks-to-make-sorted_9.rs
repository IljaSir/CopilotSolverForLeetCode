impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut count = 0;
        for (i, &a) in arr.iter().enumerate() {
            max = max.max(a);
            if max == i as i32 {
                count += 1;
            }
        }
        count
    }
}