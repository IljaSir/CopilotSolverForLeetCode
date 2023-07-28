impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut curr = 1;
        let mut prev = 0;
        for i in 1..arr.len() {
            if arr[i] > arr[i - 1] {
                if prev == -1 {
                    curr += 1;
                } else {
                    curr = 2;
                }
                prev = 1;
            } else if arr[i] < arr[i - 1] {
                if prev == 1 {
                    curr += 1;
                } else {
                    curr = 2;
                }
                prev = -1;
            } else {
                curr = 1;
                prev = 0;
            }
            max = max.max(curr);
        }
        max
    }
}