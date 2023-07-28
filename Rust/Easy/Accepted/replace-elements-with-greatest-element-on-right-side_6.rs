impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![-1; arr.len()];
        let mut max = -1;
        for i in (0..arr.len()).rev() {
            result[i] = max;
            max = max.max(arr[i]);
        }
        result
    }
}