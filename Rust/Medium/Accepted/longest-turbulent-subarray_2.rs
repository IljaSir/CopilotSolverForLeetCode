impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut cur = 1;
        let mut sign = 0;
        for i in 1..arr.len() {
            if arr[i - 1] == arr[i] {
                cur = 1;
                sign = 0;
            } else if arr[i - 1] < arr[i] {
                if sign == 1 {
                    cur += 1;
                } else {
                    cur = 2;
                }
                sign = 2;
            } else {
                if sign == 2 {
                    cur += 1;
                } else {
                    cur = 2;
                }
                sign = 1;
            }
            max = max.max(cur);
        }
        max
    }
}