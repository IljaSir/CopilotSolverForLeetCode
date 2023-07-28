impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_value = 0;
        let mut current = 0;
        let mut current_value = 0;
        for i in 0..arr.len() {
            if arr[i] == current_value {
                current += 1;
            } else {
                current_value = arr[i];
                current = 1;
            }
            if current > max {
                max = current;
                max_value = current_value;
            }
        }
        max_value
    }
}