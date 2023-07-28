impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut len = arr.len();
        let mut count = 0;
        let mut i = 0;
        while len > arr.len() / 2 {
            len -= (arr[i + 1..].iter().take_while(|&&x| x == arr[i]).count() + 1) as usize;
            i += 1;
            count += 1;
        }
        count
    }
}