impl Solution {
    pub fn maximum_element_after_decrementing_and_rearranging(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut prev = 1;
        for i in 1..arr.len() {
            if arr[i] - arr[i - 1] > 1 {
                arr[i] = arr[i - 1] + 1;
            }
            prev = arr[i];
        }
        prev
    }
}