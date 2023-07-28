impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut count = 0;
        let mut total = 0;
        let half = arr.len() / 2;
        for i in (0..arr.len()).rev() {
            total += 1;
            if i == 0 || arr[i] != arr[i - 1] {
                count += 1;
            }
            if total >= half {
                break;
            }
        }
        count
    }
}