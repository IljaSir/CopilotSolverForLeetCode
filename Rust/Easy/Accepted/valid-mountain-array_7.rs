impl Solution {
    pub fn valid_mountain_array(arr: Vec<i32>) -> bool {
        
        let mut i = 0;
        let mut j = arr.len() - 1;
        while i < j && arr[i] < arr[i + 1] {
            i += 1;
        }
        while i < j && arr[j] < arr[j - 1] {
            j -= 1;
        }
        i == j && i != 0 && j != arr.len() - 1
    }
}