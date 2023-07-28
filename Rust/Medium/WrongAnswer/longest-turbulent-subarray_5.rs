impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut current = 1;
        let mut sign = 0;
        for i in 1..arr.len() {
            if arr[i] == arr[i-1] {
                current = 1;
                sign = 0;
            } else if arr[i] > arr[i-1] {
                if sign == 1 {
                    current += 1;
                } else {
                    current = 2;
                }
                sign = 1;
            } else {
                if sign == -1 {
                    current += 1;
                } else {
                    current = 2;
                }
                sign = -1;
            }
            if current > max {
                max = current;
            }
        }
        max
    }
}