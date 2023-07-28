impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut count = 0;
        let mut prev = arr[0];
        let mut prev_count = 1;
        for i in 1..arr.len() {
            if arr[i] == prev {
                prev_count += 1;
            } else {
                if prev_count <= k {
                    count += 1;
                    k -= prev_count;
                }
                prev = arr[i];
                prev_count = 1;
            }
        }
        if prev_count <= k {
            count += 1;
        }
        arr.len() as i32 - count
    }
}