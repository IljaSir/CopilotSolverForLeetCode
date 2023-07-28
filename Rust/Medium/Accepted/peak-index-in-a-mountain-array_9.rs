impl Solution {
    pub fn peak_index_in_mountain_array(arr: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = arr.len() - 1;
        let mut m = 0;
        while l < r {
            m = (l + r) / 2;
            if arr[m] > arr[m + 1] {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l as i32
    }
}