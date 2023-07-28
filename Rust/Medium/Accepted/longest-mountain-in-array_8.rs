impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut longest = 0;
        for i in 1..arr.len() - 1 {
            let mut j = i;
            let mut inc = 0;
            let mut dec = 0;
            while j > 0 && arr[j] > arr[j - 1] {
                j -= 1;
                inc += 1;
            }
            j = i;
            while j < arr.len() - 1 && arr[j] > arr[j + 1] {
                j += 1;
                dec += 1;
            }
            if inc > 0 && dec > 0 {
                longest = std::cmp::max(longest, inc + dec + 1);
            }
        }
        longest as i32
    }
}