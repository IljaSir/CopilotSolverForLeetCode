impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut current = 1;
        let mut last = 0;
        for i in 1..arr.len() {
            if arr[i] > arr[i - 1] {
                if last == 0 || last == 1 {
                    current += 1;
                    max = max.max(current);
                } else {
                    current = 2;
                }
                last = 1;
            } else if arr[i] < arr[i - 1] {
                if last == 0 || last == -1 {
                    current += 1;
                    max = max.max(current);
                } else {
                    current = 2;
                }
                last = -1;
            } else {
                current = 1;
                last = 0;
            }
        }
        max
    }
}