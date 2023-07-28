impl Solution {
    pub fn get_xor_sum(arr1: Vec<i32>, arr2: Vec<i32>) -> i32 {
        
        let mut a = arr1[0];
        for i in 1..arr1.len() {
            a = a & arr1[i];
        }
        let mut b = arr2[0];
        for i in 1..arr2.len() {
            b = b & arr2[i];
        }
        a & b
    }
}