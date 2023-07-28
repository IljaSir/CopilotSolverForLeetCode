impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 501];
        for &n in arr.iter() {
            count[n as usize] += 1;
        }
        for i in (1..count.len()).rev() {
            if count[i] == i {
                return i as i32;
            }
        }
        -1
    }
}