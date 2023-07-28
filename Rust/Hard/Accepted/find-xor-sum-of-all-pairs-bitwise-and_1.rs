impl Solution {
    pub fn get_xor_sum(arr1: Vec<i32>, arr2: Vec<i32>) -> i32 {
        
        let mut x = 0;
        for i in 0..arr1.len() {
            x ^= arr1[i];
        }
        let mut y = 0;
        for i in 0..arr2.len() {
            y ^= arr2[i];
        }
        x & y
    }
}