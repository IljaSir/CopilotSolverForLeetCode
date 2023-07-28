impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut max = -1;
        for i in (0..arr.len()).rev() {
            result.push(max);
            if arr[i] > max {
                max = arr[i];
            }
        }
        result.reverse();
        result
    }
}