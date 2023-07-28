impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut double = false;
        for i in 0..arr.len() {
            for j in 0..arr.len() {
                if i != j {
                    if arr[i] == arr[j] * 2 {
                        double = true;
                    }
                }
            }
        }
        double
    }
}