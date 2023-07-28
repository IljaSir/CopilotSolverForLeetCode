impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut count = 0;
        let mut sum = 0;
        let mut i = arr.len() - 1;
        while sum < arr.len()/2 {
            sum += 1;
            count += 1;
            while i > 0 && arr[i] == arr[i-1] {
                i -= 1;
                sum += 1;
            }
            i -= 1;
        }
        count
    }
}