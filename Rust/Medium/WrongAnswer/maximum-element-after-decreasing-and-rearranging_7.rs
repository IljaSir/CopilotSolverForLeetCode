impl Solution {
    pub fn maximum_element_after_decrementing_and_rearranging(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut prev = 1;
        for i in 1..arr.len() {
            if arr[i] - prev > 1 {
                arr[i] = prev + 1;
            }
            prev = arr[i];
        }
        arr[arr.len() - 1]
    }
}