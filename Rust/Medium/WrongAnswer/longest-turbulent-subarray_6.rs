impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut current = 1;
        let mut sign = 0;
        for i in 1..arr.len() {
            if arr[i] == arr[i-1] {
                current = 1;
            } else {
                let new_sign = if arr[i] > arr[i-1] { 1 } else { -1 };
                if sign == 0 || sign == new_sign {
                    current += 1;
                } else {
                    current = 2;
                }
                sign = new_sign;
            }
            max = max.max(current);
        }
        max
    }
}